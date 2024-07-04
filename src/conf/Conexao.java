package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import estrutura.*;

import java.util.ArrayList;
import java.util.List;

public class Conexao {
	
	private static Connection conectar(Configuracao conf) {
		try {
			String url = "jdbc:mysql://" + conf.getHost() + ":" + conf.getPorta();
			return DriverManager.getConnection(url, conf.getUsuario(), conf.getSenha());
		} catch(Exception e){
			System.out.println("Erro: " + e.toString());
			e.printStackTrace();
			return null;
		}
	}
	
	public static void executar(Database bd, Configuracao conf) {
		try {
			Connection conn = conectar(conf);
			
			String[] script = gerarScript(bd).split("(?<=;\n)");
			
			PreparedStatement ps = null;
			
			for(String comando : script) {
				ps = conn.prepareStatement(comando);
				ps.execute();
			}

			System.out.println("Script executado com sucesso.");
			
			ps.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String gerarScript(Database bd) {
		String script = "CREATE SCHEMA IF NOT EXISTS " + bd.getNome() + ";";
		
		if(!(bd.getTabelas().isEmpty())) {
			script += "\n\nUSE " + bd.getNome() + ";\n";
			
			for(Tabela tabela : bd.getTabelas()) {
				
				// Criação das listas de chaves primárias e estrangeiras
				
				List<String> pk = new ArrayList<String>();
				List<Atributo> fk = new ArrayList<Atributo>();
				
				script += "\nCREATE TABLE IF NOT EXISTS " + tabela.getNome() + "( \n";
				for(Atributo atr : tabela.getAtributos()) {
					if(atr != tabela.getAtributos().get(0))
						script += ",\n";
					script += "	" + atr.getNome() + " " + atr.getTipoDado();
					if(atr.isPrimaryKey())
						pk.add(atr.getNome());
					if(atr.isNotNull())
						script += " NOT NULL";
					if(atr.isAutoIncrement())
						script += " AUTO_INCREMENT";
					if(atr.isUnique())
						script += ",\n	UNIQUE (" + atr.getNome() + ")";
					if(atr.getForeignKey() != null)
						fk.add(atr);
				}
				
				// Definição de chave(s) primária(s)
				
				if(!(pk.isEmpty())) {
					script += ",\n	PRIMARY KEY (";
					for(int i = 0; i < pk.size(); i++) {
						if(i > 0)
							script += ", ";
						script += pk.get(i);
					}
					script += ")";
				}
				
				// Definição de chave(s) estrangeira(s)
				
				if(!(fk.isEmpty())) {
					for(int i = 0; i < fk.size(); i++) {
						script += ",\n	FOREIGN KEY ("+ fk.get(i).getNome() + ") REFERENCES "
									+ fk.get(i).getForeignKey().getTabela() + " ("
									+ fk.get(i).getForeignKey().getChavePrimaria() + ")";
					}
				}
				
				script += "\n);\n";
			}
		}
		return script;
	}
	
}

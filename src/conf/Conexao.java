package conf;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class Conexao {
	
	public static Connection conectar(Configuracao conf) {
		try {
			String url = "jdbc:mysql://" + conf.getHost() + ":" + conf.getPorta();
			return DriverManager.getConnection(url, conf.getUsuario(), conf.getSenha());
		} catch(Exception e){
			System.out.println("Erro: " + e.toString());
			// e.printStackTrace();
			return null;
		}
	}
	
	public static void executar(Database bd, Configuracao conf) {
		try {
			Connection conn = Conexao.conectar(conf);
			
			PreparedStatement ps;
			
			String script = "CREATE SCHEMA IF NOT EXISTS " + bd.getNome() + ";";
			ps = conn.prepareStatement(script);
			ps.execute();
			System.out.println(script + "\n");
			
			if(!(bd.getTabelas().isEmpty())) {
				script = "USE " + bd.getNome() + ";";
				ps = conn.prepareStatement(script);
				ps.execute();
				System.out.println(script + "\n");
				
				for(Tabela tabela : bd.getTabelas()) {
					script = "CREATE TABLE " + tabela.getNome() + "( \n";
					for(Atributo atr : tabela.getAtributos()) {
						if(atr != tabela.getAtributos().get(0))
							script += ",\n";
						script += "	" + atr.getNome() + " " + atr.getTipoDado();
						if(atr.isPrimaryKey())
							script += " PRIMARY KEY";
						if(atr.isNotNull())
							script += " NOT NULL";
						if(atr.isAutoIncrement())
							script += "AUTO INCREMENT";
						if(atr.isUnique())
							script += ",\n	UNIQUE (" + atr.getNome() + ")";
					}
					script += "\n);";
					ps = conn.prepareStatement(script);
					ps.execute();
					System.out.println(script + "\n");
				}
			}
			
			ps.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

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
			
			String script = "CREATE SCHEMA " + bd.getNome() + ";";
			ps = conn.prepareStatement(script);
			ps.execute();
			System.out.println(script + "\n");
			
			script = "USE " + bd.getNome() + ";";
			ps = conn.prepareStatement(script);
			ps.execute();
			System.out.println(script + "\n");
			
			for(Tabela tabela : bd.getTabelas()) {
				script = "CREATE TABLE " + tabela.getNome() + "( \n";
				for(Atributo atr : tabela.getAtributos()) {
					script += atr.getNome() + " varchar(45), \n";
				}
				script += "PRIMARY KEY(" + tabela.getAtributos().get(0).getNome() + "));";
				ps = conn.prepareStatement(script);
				ps.execute();
				System.out.println(script + "\n");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

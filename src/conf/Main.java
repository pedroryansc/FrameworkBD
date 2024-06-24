package conf;

public class Main {
	public static void main(String[] args) {
		
		Configuracao conf = Configuracao.getInstance();
		
		conf.setHost("localhost");
		conf.setPorta(3306);
		conf.setUsuario("root");
		conf.setSenha("");
		
		Database bd = new Database("ControleVacinasBD");
		
		Tabela admin = new Tabela("administrador");
		
		Atributo admin_nome = new Atributo("nome");
		
		admin.addAtributo(admin_nome);
		
		bd.addTable(admin);
		
		Conexao.executar(bd, conf);
		
	}
}
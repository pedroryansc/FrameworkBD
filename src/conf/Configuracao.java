package conf;

public class Configuracao {

	private static Configuracao conf;
	
	private String host;
	private int porta;
	private String usuario;
	private String senha;
	
	private Configuracao() {
		
	}
	
	public static Configuracao getInstance() {
		if(conf == null)
			conf = new Configuracao();
		return conf;
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
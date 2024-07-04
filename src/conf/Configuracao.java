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

	public Configuracao host(String host) {
		this.host = host;
		return this;
	}

	public int getPorta() {
		return porta;
	}

	public Configuracao porta(int porta) {
		this.porta = porta;
		return this;
	}

	public String getUsuario() {
		return usuario;
	}

	public Configuracao usuario(String usuario) {
		this.usuario = usuario;
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public Configuracao senha(String senha) {
		this.senha = senha;
		return this;
	}
}
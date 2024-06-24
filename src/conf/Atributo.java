package conf;

public class Atributo {

	private String nome;
	private String tipoDado;
	private boolean primaryKey = false;
	private boolean notNull = false;
	private boolean unique = false;
	private boolean autoIncrement = false;
	
	public Atributo(String nome) {
		setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipoDado() {
		return tipoDado;
	}
	
	public void setTipoDado(String tipoDado) {
		this.tipoDado = tipoDado;
	}
	
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public boolean isNotNull() {
		return notNull;
	}
	
	public void setNotNull(boolean notNull) {
		this.notNull = notNull;
	}
	
	public boolean isUnique() {
		return unique;
	}
	
	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	
	public boolean isAutoIncrement() {
		return autoIncrement;
	}
	
	public void setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}
	
}
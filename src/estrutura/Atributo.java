package estrutura;

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

	public String getTipoDado() {
		return tipoDado;
	}
	
	public void integer() {
		tipoDado = "INT";
	}
	
	public void decimal() {
		tipoDado = "DECIMAL";
	}
	
	public void decimal(int tamanho, int d) {
		if(tamanho >= 1 && tamanho <= 65 && d >= 0 && d <= 30 && tamanho > d)
			tipoDado = "DECIMAL(" + tamanho + ", " + d + ")";
	}
	
	public void varchar(int tamanho) {
		if(tamanho >= 0)
			tipoDado = "VARCHAR(" + tamanho + ")";
	}
	
	public void date() {
		tipoDado = "DATE";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	
	public void primaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public boolean isNotNull() {
		return notNull;
	}
	
	public void notNull(boolean notNull) {
		this.notNull = notNull;
	}
	
	public boolean isUnique() {
		return unique;
	}
	
	public void unique(boolean unique) {
		this.unique = unique;
	}
	
	public boolean isAutoIncrement() {
		return autoIncrement;
	}
	
	public void autoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}
	
}
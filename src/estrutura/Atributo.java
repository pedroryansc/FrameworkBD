package estrutura;

public class Atributo {

	private String nome;
	private String tipoDado;
	private boolean primaryKey = false;
	private ChaveEstrangeira foreignKey = null;
	private boolean notNull = false;
	private boolean unique = false;
	private boolean autoIncrement = false;
	
	public Atributo(String nome) {
		nome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	
	public Atributo nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public String getTipoDado() {
		return tipoDado;
	}
	
	public Atributo integer() {
		tipoDado = "INT";
		return this;
	}
	
	public Atributo decimal() {
		tipoDado = "DECIMAL";
		return this;
	}
	
	public Atributo decimal(int tamanho, int d) {
		if(tamanho >= 1 && tamanho <= 65 && d >= 0 && d <= 30 && tamanho > d)
			tipoDado = "DECIMAL(" + tamanho + ", " + d + ")";
		return this;
	}
	
	public Atributo varchar(int tamanho) {
		if(tamanho >= 0)
			tipoDado = "VARCHAR(" + tamanho + ")";
		return this;
	}
	
	public Atributo date() {
		tipoDado = "DATE";
		return this;
	}
	
	public Atributo bool() {
		tipoDado = "BOOL";
		return this;
	}
	
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	
	public Atributo primaryKey() {
		primaryKey = true;
		return this;
	}
	
	public ChaveEstrangeira getForeignKey() {
		return foreignKey;
	}

	public Atributo foreignKey(String chavePrimaria, Tabela tabela) {
		foreignKey = new ChaveEstrangeira(chavePrimaria, tabela.getNome());
		return this;
	}

	public boolean isNotNull() {
		return notNull;
	}
	
	public Atributo notNull() {
		notNull = true;
		return this;
	}
	
	public boolean isUnique() {
		return unique;
	}
	
	public Atributo unique() {
		unique = true;
		return this;
	}
	
	public boolean isAutoIncrement() {
		return autoIncrement;
	}
	
	public Atributo autoIncrement() {
		autoIncrement = true;
		return this;
	}
	
}
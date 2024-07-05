package estrutura;

import java.util.List;
import java.util.ArrayList;

public class Database {

	private String nome;
	private List<Tabela> tabelas = new ArrayList<Tabela>();

	public Database(String nome) {
		setNome(nome);
	}
	
	public Tabela criarTabela(String nome) {
		Tabela tabela = new Tabela(nome);
		tabelas.add(tabela);
		return tabela;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Tabela> getTabelas() {
		return tabelas;
	}
	
}
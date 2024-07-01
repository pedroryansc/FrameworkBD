package estrutura;

import java.util.List;
import java.util.ArrayList;

public class Database {

	private String nome;
	private List<Tabela> tabelas = new ArrayList<Tabela>();
	
	public Database() {
		
	}
	
	public Database(String nome) {
		setNome(nome);
	}
	
	public void addTabela(Tabela tabela) {
		tabelas.add(tabela);
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
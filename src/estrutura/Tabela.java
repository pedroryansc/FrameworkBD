package estrutura;

import java.util.List;
import java.util.ArrayList;

public class Tabela {

	private String nome;
	private List<Atributo> atributos = new ArrayList<Atributo>();
	
	public Tabela() {
		
	}
	
	public Tabela(String nome) {
		setNome(nome);
	}
	
	public Atributo criarAtributo(String nome) {
		Atributo atr = new Atributo(nome);
		atributos.add(atr);
		return atr;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Atributo> getAtributos() {
		return atributos;
	}
	
}
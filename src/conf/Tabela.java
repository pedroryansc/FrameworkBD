package conf;

import java.util.List;
import java.util.ArrayList;

public class Tabela {

	private String nome;
	private List<Atributo> atributos = new ArrayList<Atributo>();
	
	public Tabela(String nome) {
		setNome(nome);
	}
	
	public void addAtributo(Atributo atr) {
		atributos.add(atr);
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

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
	
}
package estrutura;

public class ChaveEstrangeira {

	private String chavePrimaria;
	private String tabela;
	
	public ChaveEstrangeira(String chavePrimaria, String tabela) {
		setChavePrimaria(chavePrimaria);
		setTabela(tabela);
	}

	public String getChavePrimaria() {
		return chavePrimaria;
	}

	public void setChavePrimaria(String chavePrimaria) {
		this.chavePrimaria = chavePrimaria;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}
	
}
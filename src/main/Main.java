package main;

import conf.*;
import estrutura.*;

public class Main {
	public static void main(String[] args) {
		
		// Configuração dos parâmetros de conexão com o SGBD
		
		Configuracao conf = Configuracao.getInstance();
		
		conf.setHost("localhost");
		conf.setPorta(3306);
		conf.setUsuario("root");
		conf.setSenha("Sobaoeim123#");
		
		// Criação da estrutura do banco de dados
		
		Database bd = new Database("vendas");
		
		// Criação da tabela
		
		Tabela jogos = new Tabela("jogos");
		
		// Criação e configuração dos atributos
		
		Atributo id = new Atributo("id");
		id.integer();
		id.primaryKey(true);
		id.notNull(true);
		id.unique(true);
		
		Atributo nome = new Atributo("nome");
		nome.varchar(255);
		nome.notNull(true);
		
		Atributo plataforma = new Atributo("plataforma");
		plataforma.varchar(45);
		plataforma.notNull(true);
		
		Atributo preco = new Atributo("preco");
		preco.decimal(6, 2);
		preco.notNull(true);
		
		Atributo dataLancamento = new Atributo("dataLancamento");
		dataLancamento.date();
		dataLancamento.notNull(true);
		
		// Montagem do banco de dados
		
		jogos.addAtributo(id);
		jogos.addAtributo(nome);
		jogos.addAtributo(plataforma);
		jogos.addAtributo(preco);
		jogos.addAtributo(dataLancamento);
		
		bd.addTabela(jogos);
		
		Tabela trator = new Tabela("trator");
		
		trator.addAtributo(id);
		
		Atributo modelo = new Atributo("modelo");
		modelo.varchar(45);
		
		trator.addAtributo(modelo);
		
		bd.addTabela(trator);
		
		// Execução do script para criar o banco de dados no SGBD
		
		Conexao.executar(bd, conf);
		
	}
}
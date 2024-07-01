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
		id.autoIncrement(true);
		
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
		
		// Adição de uma nova tabela
		
		Tabela trator = new Tabela("trator");
		
		trator.addAtributo(id);
		
		Atributo modelo = new Atributo("modelo");
		modelo.varchar(45);
		
		trator.addAtributo(modelo);
		
		bd.addTabela(trator);
		
		// Tabela com chaves estrangeiras
		
		Tabela vendaJogo = new Tabela("vendaJogo");
		
		vendaJogo.addAtributo(id);
		
		Atributo dataVenda = new Atributo("dataVenda");
		dataVenda.date();
		dataVenda.notNull(true);
		
		Atributo pago = new Atributo("pago");
		pago.bool();
		pago.notNull(true);
		
		Atributo id_jogo = new Atributo("id_jogo");
		id_jogo.integer();
		id_jogo.notNull(true);
		id_jogo.foreignKey("id", "jogos");
		
		Atributo id_trator = new Atributo("id_trator");
		id_trator.integer();
		id_trator.notNull(true);
		id_trator.foreignKey("id", "trator");
		
		vendaJogo.addAtributo(dataVenda);
		vendaJogo.addAtributo(pago);
		vendaJogo.addAtributo(id_jogo);
		vendaJogo.addAtributo(id_trator);
		
		bd.addTabela(vendaJogo);
		
		// Execução do script para criar o banco de dados no SGBD
		
		Conexao.executar(bd, conf);
		
	}
}
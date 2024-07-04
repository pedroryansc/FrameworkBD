package main;

import conf.*;
import estrutura.*;

public class Main {
	public static void main(String[] args) {
		
		// Configuração dos parâmetros de conexão com o SGBD
		
		Configuracao conf = Configuracao.getInstance();
		
		conf.host("localhost");
		conf.porta(3306);
		conf.usuario("root");
		conf.senha("");
		
		// Criação da estrutura do banco de dados
		
		Database bd = new Database("vendas");
		
		// Tabela simples
		
		Tabela cliente = new Tabela("cliente");
		
		// Criação e configuração dos atributos
		
		cliente.criarAtributo("id").integer().primaryKey().notNull().unique().autoIncrement();
		cliente.criarAtributo("nome").varchar(45).notNull();
		cliente.criarAtributo("dataNascimento").date();
		
		// Montagem do Banco de Dados
		
		bd.addTabela(cliente);
		
		// Criação de uma nova tabela simples
		
		Tabela forn = new Tabela("fornecedor");
		
		forn.criarAtributo("id").integer().primaryKey().notNull().unique().autoIncrement();
		forn.criarAtributo("nome").varchar(45).notNull();
		
		bd.addTabela(forn);
		
		// Tabela com chave estrangeira
		
		Tabela produto = new Tabela("produto");
		
		produto.criarAtributo("id").varchar(45).primaryKey().notNull().unique();
		produto.criarAtributo("descricao").varchar(45).notNull();
		produto.criarAtributo("preco_unidade").decimal(6,2).notNull();
		produto.criarAtributo("id_fornecedor").integer().notNull().foreignKey("id", forn);
		
		bd.addTabela(produto);
		
		// Tabela associativa
		
		Tabela venda = new Tabela("venda");
		
		venda.criarAtributo("id").integer().primaryKey().notNull().unique().autoIncrement();
		venda.criarAtributo("id_cliente").integer().primaryKey().notNull().foreignKey("id", cliente);
		venda.criarAtributo("id_produto").varchar(45).primaryKey().notNull().foreignKey("id", produto);
		venda.criarAtributo("quant").integer().notNull();
		venda.criarAtributo("preco_total").decimal(6,2).notNull();
		venda.criarAtributo("pago").bool().notNull();
		
		bd.addTabela(venda);
		
		// Geração e execução do script para criar o banco de dados no SGBD
		
		System.out.println(Conexao.gerarScript(bd));
		
		Conexao.executar(bd, conf);
		
	}
}
package main;

import conf.*;
import estrutura.*;

public class Main {
	public static void main(String[] args) {
		
		// Configuração dos parâmetros de conexão com o SGBD
		
		Configuracao conf = Configuracao.getInstance().host("localhost").porta(3306).usuario("root").senha("Sobaoeim123#");
		
		// Criação da estrutura do banco de dados
		
		Database bd = new Database("vendas");
		
		// Tabela simples
		
		Tabela cliente = bd.criarTabela("cliente");
		
		// Criação e configuração dos atributos
		
		cliente.criarAtributo("id").integer().primaryKey().notNull().unique().autoIncrement();
		cliente.criarAtributo("nome").varchar(45).notNull();
		cliente.criarAtributo("dataNascimento").date();
		
		// Criação de uma nova tabela simples
		
		Tabela forn = bd.criarTabela("fornecedor");
		
		forn.criarAtributo("id").integer().primaryKey().notNull().unique().autoIncrement();
		forn.criarAtributo("nome").varchar(45).notNull();
		
		// Tabela com chave estrangeira
		
		Tabela produto = bd.criarTabela("produto");
		
		produto.criarAtributo("id").varchar(45).primaryKey().notNull().unique();
		produto.criarAtributo("descricao").varchar(45).notNull();
		produto.criarAtributo("preco_unidade").decimal(6,2).notNull();
		produto.criarAtributo("id_fornecedor").integer().notNull().foreignKey("id", forn);
		
		// Tabela associativa
		
		Tabela venda = bd.criarTabela("venda");
		
		venda.criarAtributo("id").integer().primaryKey().notNull().unique().autoIncrement();
		venda.criarAtributo("id_cliente").integer().primaryKey().notNull().foreignKey("id", cliente);
		venda.criarAtributo("id_produto").varchar(45).primaryKey().notNull().foreignKey("id", produto);
		venda.criarAtributo("quant").integer().notNull();
		venda.criarAtributo("preco_total").decimal(6,2).notNull();
		venda.criarAtributo("pago").bool().notNull();
		
		// Geração e execução do script para criar o banco de dados no SGBD
		
		System.out.println(Conexao.gerarScript(bd));
		
		Conexao.executar(bd, conf);
		
	}
}
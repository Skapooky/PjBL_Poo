package entities;

import java.io.*;

import entities.enums.TipoProduto;
import persistent.Estoque;

public abstract class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected TipoProduto classe;
	protected String nome;
	protected double preco;
	protected int quantidade;
	
	protected Estoque estoque;
	
	public Produto(){}


	public Produto(Estoque estoque, int id, TipoProduto classe, String nome, double preco, int quantidade) {
		this.id = id;
		this.classe = classe;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.estoque = estoque;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public TipoProduto getClasse() {
		return classe;
	}
	public void setClasse(TipoProduto classe) {
		this.classe = classe;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public abstract double getImpostos();
	
	public String toString() {
		return classe +
				": " +
				nome +
				", R$" +
				preco +
				", " +
				quantidade +
				" em estoque.";
	};
	
}

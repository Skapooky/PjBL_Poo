package entities;

import java.text.DecimalFormat;

import entities.enums.TipoProduto;
import persistent.Estoque;

public class ProdutoEletrodomestico extends Produto{
	
	private static final long serialVersionUID = 1L;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private int voltagem;
	
	public ProdutoEletrodomestico(Estoque estoque, int id, TipoProduto classe, String nome, double preco, int quantidade, int voltagem) {
		super(estoque, id, classe, nome, preco, quantidade);
		this.voltagem = voltagem;
	}

	public int getVoltagem() {
		return voltagem;
	}
	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}

	@Override
	public String toString() {
		return classe + 
				": " +
				"ID " + 
				id +
				" - " +
				nome +
				" " +
				voltagem +
				" V" +
				". R$" +
				preco +
				" (imposto R$" +
				df.format(getImpostos()) +
				")"+
				", " +
				quantidade +
				" em estoque.";
	}

	@Override
	public double getImpostos() {
		double imposto = preco * 0.06;
		return imposto;
	}
}

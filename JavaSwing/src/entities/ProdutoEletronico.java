package entities;

import java.text.DecimalFormat;

import entities.enums.TipoProduto;
import persistent.Estoque;

public class ProdutoEletronico extends Produto{
	
	private static final long serialVersionUID = 1L;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private int anoFabricacao;
	private String fabricante;
	
	public ProdutoEletronico(Estoque estoque, int id, TipoProduto classe, String nome, double preco, int quantidade,int anoFabricacao,
			String fabricante) {
		super(estoque, id, classe, nome, preco, quantidade);
		this.anoFabricacao = anoFabricacao;
		this.fabricante = fabricante;
	}
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return classe + 
				": " +
				"ID " + 
				id +
				" - " +
				nome +
				". " +
				"Fabricante: " +
				fabricante +
				", fabricado no ano: " +
				anoFabricacao +
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
		double imposto = preco * 0.1;
		return imposto;
	}
}

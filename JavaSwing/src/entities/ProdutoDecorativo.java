package entities;

import java.text.DecimalFormat;

import entities.enums.TipoProduto;
import persistent.Estoque;

public class ProdutoDecorativo extends Produto{

	private static final long serialVersionUID = 1L;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private String material;
	private String cor;
	private String faixaEtaria;
	
	public ProdutoDecorativo(Estoque estoque, int id, TipoProduto classe, String nome, double preco, int quantidade, String material, String cor,
		String faixaEtaria) {
		super(estoque, id, classe, nome, preco, quantidade);
		this.material = material;
		this.cor = cor;
		this.faixaEtaria = faixaEtaria;
		
	}
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getFaixaEtaria() {
		return faixaEtaria;
	}
	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
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
				cor +
				", " +
				faixaEtaria +
				". Material: " +
				material +
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
		double imposto = preco * 0.01;
		return imposto;
	}
	
}

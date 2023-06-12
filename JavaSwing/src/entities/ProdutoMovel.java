package entities;

import java.text.DecimalFormat;

import entities.enums.TipoProduto;
import persistent.Estoque;

public class ProdutoMovel extends Produto{
	
	private static final long serialVersionUID = 1L;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private String material;
	private String ambienteCasa;
	private boolean usado;
	
	
	public ProdutoMovel(Estoque estoque, int id, TipoProduto classe, String nome, double preco, int quantidade, String material, String ambienteCasa,
			boolean usado){
		super(estoque, id, classe, nome, preco, quantidade);
		this.material = material;
		this.ambienteCasa = ambienteCasa;
		this.usado = usado;
	}
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	public String getAmbienteCasa() {
		return ambienteCasa;
	}
	public void setAmbienteCasa(String ambienteCasa) {
		this.ambienteCasa = ambienteCasa;
	}

	public boolean isUsado() {
		return usado;
	}
	public void setUsado(boolean usado) {
		this.usado = usado;
	}



	@Override
	public String toString() {
		String usadoString;
		if(usado) {
			usadoString = "(usado)";
		} else {
			usadoString = "(novo)";
		}
		return  classe + 
				": " +
				"ID " + 
				id +
				" - " +
				nome +
				". " +
				usadoString +
				". Ambiente:" +
				ambienteCasa +
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
		double imposto = preco * 0.02;
		return imposto;
	}
	
	
}

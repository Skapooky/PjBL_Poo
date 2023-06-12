package persistent;

import java.util.ArrayList;

import entities.Produto;
import exceptions.ProductAlredyExists;
import exceptions.ProductNotFound;

import java.io.*;

public class Estoque implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<String> relatorio = new ArrayList<String>();
	
	//Reseta relatório
	public void resetarRelatorio() {
		relatorio.removeAll(relatorio);
	}
	
	//Checa se produto ja existe
	public boolean checarExistencia(Produto produto, int id) {
		if(produto.getId() == id) {
			return true;
		}
		return false;
	}
	
	//Adiciona produto na lista do estoque.
	public void adicionarProduto(Produto produto) throws ProductAlredyExists{
		for(Produto produtoA: produtos) {
			if(checarExistencia(produtoA, produto.getId())) {
				throw new ProductAlredyExists("Produto ja existe!");
			}
		}
		produtos.add(produto);
	}
	
	//Diminui quantidade de produto do estoque
	public void diminuiProduto(int id, int quantidade) throws ProductNotFound{
		for(Produto produtoA: produtos) {
			if(produtoA.getId() == id){
				if((produtoA.getQuantidade() - quantidade) < 0) {
					relatorio.add("Saiu: " + produtoA.getQuantidade() + " " + produtoA.getNome());
					produtoA.setQuantidade(0);
					return;
				}
				else {
					relatorio.add("Saiu: " + quantidade + " " + produtoA.getNome());
					produtoA.setQuantidade(produtoA.getQuantidade() - quantidade);
					return;
				}
			}
		}
		throw new ProductNotFound("Produto não encontrado!");
	}
	
	//Aumenta a quantidado do produto no estoque
	public void aumentaProduto(int id, int quantidade) throws ProductNotFound{
		for(Produto produtoA: produtos) {
			if(produtoA.getId() == id){
				produtoA.setQuantidade(produtoA.getQuantidade() + quantidade);
				relatorio.add("Entrou: " + quantidade + " " + produtoA.getNome());
				return;
			}
		}
		throw new ProductNotFound("Produto não encontrado!");
	}
	
	//Printa produtos no terminal
	public void getProdutos() {
		System.out.println();
		System.out.println("Produtos no estoque: ");
		for(Produto produto: produtos) {
			System.out.println(produto);
		}
		System.out.println();
	}
	
	//Salva o estoque em um arquivo .txt
	public void salvar(String nome_arquivo) throws IOException {
		
		FileOutputStream output = new FileOutputStream(nome_arquivo);
		ObjectOutputStream gravador = new ObjectOutputStream(output);
		
		gravador.writeObject(this);
		
		gravador.close();
		output.close();
	}
	
	//Recupera arquivo .txt que salva o estoque
	public static Estoque recuperar(String nome_arquivo) throws IOException, ClassNotFoundException{
		
		Estoque estoque = null;
		FileInputStream arquivo = new FileInputStream(nome_arquivo);
		ObjectInputStream restaurador = new ObjectInputStream(arquivo);
		
		estoque = (Estoque) restaurador.readObject();
		
		restaurador.close();
		arquivo.close();
		
		return estoque;
	}
	
	//Remove todos os produtos do estoque e salva
	public void resetar() throws IOException {
		produtos.removeAll(produtos);
		
		this.salvar("Estoque.txt");
	}
	
	//Salva um relatorio .txt 
	public void relatorio(String nome_arquivo) throws IOException {
		FileOutputStream output = new FileOutputStream(nome_arquivo);
		for(String linha : relatorio) {
			String linhaWrite = linha + "\n";
			byte[] textoByte = linhaWrite.getBytes();
			output.write(textoByte);
		}
		output.close();
	}
}

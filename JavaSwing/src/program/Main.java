package program;

import java.io.IOException;

import entities.Produto;
import exceptions.ProductAlredyExists;
import exceptions.ProductNotFound;
import persistent.Estoque;
import views.MainGUI;

public class Main {
	
	public static Estoque estoque;
	
	public static void main(String[] args) {
		
		//Recuperação do estoque
		try {
			estoque = Estoque.recuperar("Estoque.txt");
			estoque.resetarRelatorio();
			System.out.println("Estoque recuperado!");
		}
		catch(IOException e) {
			System.out.println("Fala ao recuperar estoque: Excecao I/O");
			System.out.println("Criando novo estoque...");
			estoque = new Estoque();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Fala ao recuperar estoque: Classe desconhecida");
			System.out.println("Criando novo estoque...");
			estoque = new Estoque();
		}
		
		//Chamada da interface
		@SuppressWarnings("unused")
		MainGUI tela = new MainGUI();

	}
	
	//Funções de alteração de estoque
	public static void registrar(Produto produto) throws ProductAlredyExists {
		estoque.adicionarProduto(produto);
	}
	
	public static void remover(int id, int quantidade) throws ProductNotFound{
		estoque.diminuiProduto(id, quantidade);
	}
	
	public static void adicionar(int id, int quantidade) throws ProductNotFound {
		estoque.aumentaProduto(id, quantidade);
	}
	
	public static void salvar(String nome_arquivo) throws IOException {
		estoque.salvar(nome_arquivo);
	}

	public static void getEstoque() {
		estoque.getProdutos();
	}
	
	public static void resetar() throws IOException {
		estoque.resetar();
	}
	
	public static void relatorio() throws IOException {
		estoque.relatorio("Relatorio.txt");
	}
}

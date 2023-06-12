package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;

import exceptions.ProductNotFound;
import program.Main;

public class AtualizarProduto {
	
	protected JPanel erros = new JPanel();
	private JFrame frame = new JFrame("Retira");
	private JTextField idInput, quantidadeInput;
	private JButton botaoRemover = new JButton("Remover");
	private JButton botaoAdicionar = new JButton("Adicionar");
	private JButton botaoVoltar = new JButton("Voltar");
	
	
	public AtualizarProduto() {
		
		JLabel id = new JLabel("Id");
		id.setBounds(150, 180, 100, 100);
		id.setFont(new Font("Serif", Font.PLAIN, 30));
		idInput = new JTextField(20);
		idInput.setBounds(310, 220, 150, 30);
		idInput.setFont(new Font("Serif", Font.PLAIN, 30));
		
		JLabel quantidade = new JLabel("Quantidade");
		quantidade.setBounds(150, 220, 200, 100);
		quantidade.setFont(new Font("Serif", Font.PLAIN, 30));
		quantidadeInput = new JTextField(20);
		quantidadeInput.setBounds(310, 260, 150, 30);
		quantidadeInput.setFont(new Font("Serif", Font.PLAIN, 30));
		
		botaoRemover.setBounds(150, 360, 150, 50);
		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel check = new JLabel();
				check.setFont(new Font("Serif", Font.PLAIN, 30));
				
				try {
					int id = Integer.parseInt(idInput.getText());
					int quantidade = Integer.parseInt(quantidadeInput.getText());
					
					Main.remover(id, quantidade);
					Main.salvar("Estoque.txt");
					
					erros.removeAll();
					erros.repaint();
					check.setText("Atualizado!");
					check.setForeground(Color.GREEN);
					erros.add(check);
					erros.validate();
					erros.repaint();
					
					System.out.println("Estoque atualizado!");
				}
				catch(NumberFormatException exception){
					erros.removeAll();
					erros.repaint();
					check.setText("Valores invalidos!");
					check.setForeground(Color.RED);
					erros.add(check);
					erros.validate();
					erros.repaint();
				} 
				catch (IOException exception) {
					System.out.println("Excecao de I/O");
					exception.printStackTrace();
				}
				catch (ProductNotFound exception) {
					// TODO Auto-generated catch block
					erros.removeAll();
					erros.repaint();
					check.setText("Não encontrado!");
					check.setForeground(Color.RED);
					
					erros.add(check);
					erros.validate();
					erros.repaint();
				}	
			}
		});
		
		botaoAdicionar.setBounds(310, 360, 150, 50);
		botaoAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel check = new JLabel();
				check.setFont(new Font("Serif", Font.PLAIN, 30));
				
				try {
					int id = Integer.parseInt(idInput.getText());
					int quantidade = Integer.parseInt(quantidadeInput.getText());
					
					Main.adicionar(id, quantidade);
					Main.salvar("Estoque.txt");
					
					erros.removeAll();
					erros.repaint();
					check.setText("Atualizado!");
					check.setForeground(Color.GREEN);
					erros.add(check);
					erros.validate();
					erros.repaint();
					
					System.out.println("Estoque atualizado!");
				}
				catch(NumberFormatException exception){
					erros.removeAll();
					erros.repaint();
					check.setText("Valores invalidos!");
					check.setForeground(Color.RED);
					erros.add(check);
					erros.validate();
					erros.repaint();
				} 
				catch (IOException exception) {
					System.out.println("Excecao de I/O");
					exception.printStackTrace();
				} 
				catch (ProductNotFound exception) {
					// TODO Auto-generated catch block
					erros.removeAll();
					erros.repaint();
					check.setText("Não encontrado!");
					check.setForeground(Color.RED);
					erros.add(check);
					erros.validate();
					erros.repaint();
				}		
			}
		});
		
		botaoVoltar.setBounds(150, 420, 310, 50);
		botaoVoltar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == botaoVoltar) {
				
				frame.dispose();
				
				@SuppressWarnings("unused")
				MainGUI main = new MainGUI();
				
			}
		}
	});
		
		erros.setBounds(190, 480, 240, 50);
		erros.setOpaque(true);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				try {
					Main.relatorio();
				} catch (IOException e) {
					System.out.println("Erro: Excecao de I/O");
					e.printStackTrace();
				}
			}
		});
		
		//Adicionando objetos na interface
		frame.add(id);
		frame.add(idInput);
		frame.add(quantidade);
		frame.add(quantidadeInput);
		frame.add(botaoRemover);
		frame.add(botaoAdicionar);
		frame.add(botaoVoltar);
		frame.add(erros);
		
		//Adicionando configurações padrão
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600,600);
	    frame.setLocationRelativeTo(null);
	    frame.setLayout(null);
	    frame.setVisible(true);
	}
	
}

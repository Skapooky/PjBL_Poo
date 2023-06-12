package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import program.Main;

public class MainGUI {
	
	private JFrame frame = new JFrame("Registro");
	
	private JButton eletrodomestico = new JButton("Eletrodoméstico");
	private JButton eletronico = new JButton("Eletronico");
	private JButton decorativo = new JButton("Decorativo");
	private JButton movel = new JButton("Movel");
	private JButton mostrarEstoque = new JButton("Mostrar estoque");
	private JButton resetarEstoque = new JButton("Resetar");
	private JButton atualizarProduto = new JButton("Atualizar produto");
	private JLabel registrar = new JLabel("-- Registro --");
	private JLabel atualizar = new JLabel("-- Atualizar --");
	
	
	public MainGUI() {
		
		registrar.setBounds(170, 40, 400, 50);
		registrar.setFont(new Font("Monospaced", Font.PLAIN, 30));
		
		atualizar.setBounds(160, 320, 400, 50);
		atualizar.setFont(new Font("Monospaced", Font.PLAIN, 30));
		
		eletrodomestico.setBounds(80, 120, 200, 50);
		eletrodomestico.setFocusable(false);
		
		eletronico.setBounds(320, 120, 200, 50);
		eletronico.setFocusable(false);
		
		decorativo.setBounds(80, 220, 200, 50);
		decorativo.setFocusable(false);
		
		movel.setBounds(320, 220, 200, 50);
		movel.setFocusable(false);
		
		mostrarEstoque.setBounds(80, 400, 200, 50);
		mostrarEstoque.setFocusable(false);
				atualizarProduto.setBounds(320, 400, 200, 50);		atualizarProduto.setFocusable(false);
		
		resetarEstoque.setBounds(460, 520, 80, 20);
		resetarEstoque.setFocusable(false);
		
		eletrodomestico.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == eletrodomestico) {
					
					frame.dispose();
					
					@SuppressWarnings("unused")
					FormEletrodomestico formulario = new FormEletrodomestico();
					
				}
			}
		});
		
		eletronico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == eletronico) {
				
					frame.dispose();
					
					@SuppressWarnings("unused")
					FormEletronico formulario = new FormEletronico();
					
				}
			}
		});
		
		decorativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == decorativo) {
				
					frame.dispose();
					
					@SuppressWarnings("unused")
					FormDecorativo formulario = new FormDecorativo();
					
				}
			}
		});
		
		movel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == movel) {
					
					frame.dispose();
					
					@SuppressWarnings("unused")
					FormMovel formulario = new FormMovel();
					
				}
			}
		});
		
		mostrarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mostrarEstoque) {
					
					Main.getEstoque();
					
				}
			}
		});
		
		atualizarProduto.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
				@SuppressWarnings("unused")
				AtualizarProduto formulario = new AtualizarProduto();
				
			}
		});
		
		resetarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == resetarEstoque) {
					
					try {
						Main.resetar();
						System.out.println("Estoque resetado!");
					}
					catch(IOException exception) {
						System.out.println("Erro: Excecao I/O");
					}
					
				}
			}
		});
		
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
		
		//Adicionando elementos
		frame.add(eletrodomestico);
		frame.add(eletronico);
		frame.add(decorativo);
		frame.add(movel);
		frame.add(mostrarEstoque);
		frame.add(resetarEstoque);
		frame.add(atualizarProduto);
		frame.add(registrar);
		frame.add(atualizar);
		
		//Adicionando configurações padrão
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
}

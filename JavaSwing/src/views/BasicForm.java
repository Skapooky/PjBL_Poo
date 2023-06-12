package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import program.Main;

public abstract class BasicForm {
	
	protected JTextField nomeInput, idInput, precoInput, quantidadeInput, voltagemInput, fabricanteInput, anoInput, materialInput, corInput, ambienteInput;
	@SuppressWarnings("rawtypes")
	protected JComboBox faixaEtariaInput;
	protected JCheckBox usadoInput;
	protected JFrame frame = new JFrame("Formulário");
	protected JPanel erros = new JPanel();
	
	protected JButton botaoRegister = new JButton("Registrar");
	protected JButton botaoVoltar = new JButton("Voltar");
	
	public BasicForm() {
		
		//Criando inputs basicos
		
			//ID
			JLabel id = new JLabel("ID");
			id.setBounds(150, 60, 100, 100);
			id.setFont(new Font("Serif", Font.PLAIN, 30));
			idInput = new JTextField(20);
			idInput.setBounds(310, 100, 150, 30);
			idInput.setFont(new Font("Serif", Font.PLAIN, 30));
			
			//Nome
			JLabel nome = new JLabel("Nome");
			nome.setBounds(150, 100, 100, 100);
			nome.setFont(new Font("Serif", Font.PLAIN, 30));
			nomeInput = new JTextField(20);
			nomeInput.setBounds(310, 140, 150, 30);
			nomeInput.setFont(new Font("Serif", Font.PLAIN, 30));
			
			//Preco
			JLabel preco = new JLabel("Preço");
			preco.setBounds(150, 140, 100, 100);
			preco.setFont(new Font("Serif", Font.PLAIN, 30));
			precoInput = new JTextField(20);
			precoInput.setBounds(310, 180, 150, 30);
			precoInput.setFont(new Font("Serif", Font.PLAIN, 30));
			
			//Quantidade
			JLabel quantidade = new JLabel("Quantidade");
			quantidade.setBounds(150, 180, 200, 100);
			quantidade.setFont(new Font("Serif", Font.PLAIN, 30));
			quantidadeInput = new JTextField(20);
			quantidadeInput.setBounds(310, 220, 150, 30);
			quantidadeInput.setFont(new Font("Serif", Font.PLAIN, 30));
		
		
		//Criando detector do botão para mostrar produtos
			botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botaoVoltar) {
					
					frame.dispose();
					
					@SuppressWarnings("unused")
					MainGUI main = new MainGUI();
					
				}
			}
		});
			
		//Criando JPanel para erros
		erros.setBounds(190, 430, 220, 50);
		erros.setOpaque(true);
		
		//Adicionando Listner para salvar relatório
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
		frame.add(erros);
		frame.add(id);
		frame.add(idInput);
		frame.add(nome);
		frame.add(nomeInput);
		frame.add(preco);
		frame.add(precoInput);
		frame.add(quantidade);
		frame.add(quantidadeInput);
		
		//Adicionando configurações padrão
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600,600);
	    frame.setLocationRelativeTo(null);
	    frame.setLayout(null);
	    frame.setVisible(true);
	}
	
}

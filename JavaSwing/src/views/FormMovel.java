package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import entities.*;
import entities.enums.*;
import exceptions.ProductAlredyExists;
import program.Main;

public class FormMovel extends BasicForm{

	public FormMovel() {
		
		erros.setBounds(190, 460, 220, 50);
		
		//Criando botão para voltar para o menu
		botaoVoltar.setBounds(150, 400, 150, 40);
				
		botaoRegister.setBounds(310, 400, 150, 40);
		botaoRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Criando texto de check para ser adicionado no painel
				JLabel check = new JLabel();
				check.setFont(new Font("Serif", Font.PLAIN, 30));
				
				try {
					int id = Integer.parseInt(idInput.getText());
					String nome = nomeInput.getText();
					double preco = Double.parseDouble(precoInput.getText());
					int quantidade = Integer.parseInt(quantidadeInput.getText());
					String material = materialInput.getText();
					String ambiente = ambienteInput.getText();
					boolean usadoValue = usadoInput.isSelected();
					
					Main.registrar(new ProdutoMovel(Main.estoque, id, TipoProduto.MOVEL, nome, preco, quantidade, material, ambiente, usadoValue));
					Main.salvar("Estoque.txt");
					
					erros.removeAll();
					erros.repaint();
					check.setText("Produto registrado!");
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
				}
				catch (ProductAlredyExists exception) {
					erros.removeAll();
					erros.repaint();
					check.setText("Produto ja existe!");
					check.setForeground(Color.RED);
					erros.add(check);
					erros.validate();
					erros.repaint();
				}
			}
		});
		
		//Adicionar campo de MATERIAL ao Formulário
		JLabel material = new JLabel("Material");
		material.setBounds(150, 220, 200, 100);
		material.setFont(new Font("Serif", Font.PLAIN, 30));
		materialInput = new JTextField(20);
		materialInput.setBounds(310, 260, 150, 30);
		materialInput.setFont(new Font("Serif", Font.PLAIN, 30));
						
		//Adicionar campo de AMBIENTE ao Formulário
		JLabel ambiente = new JLabel("Ambiente");
		ambiente.setBounds(150, 260, 200, 100);
		ambiente.setFont(new Font("Serif", Font.PLAIN, 30));
		ambienteInput = new JTextField(20);
		ambienteInput.setBounds(310, 300, 150, 30);
		ambienteInput.setFont(new Font("Serif", Font.PLAIN, 30));
		
		//Adicionar campo de USADO ao Formulário
		JLabel usado = new JLabel("Usado");
		usado.setBounds(150, 340, 150, 30);
		usado.setFont(new Font("Serif", Font.PLAIN, 30));
		usadoInput = new JCheckBox();
		usadoInput.setBounds(310, 340, 150, 30);
		usadoInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		usadoInput.setBorderPainted(true);
		usadoInput.setHorizontalAlignment(SwingConstants.CENTER);
		usadoInput.setBackground(Color.WHITE);
		usadoInput.setFocusable(false);
				
		frame.add(botaoVoltar);
		frame.add(botaoRegister);
		frame.add(material);
		frame.add(materialInput);
		frame.add(ambiente);
		frame.add(ambienteInput);
		frame.add(usado);
		frame.add(usadoInput);
		
		
	}
	
}

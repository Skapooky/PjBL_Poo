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

public class FormEletrodomestico extends BasicForm{
	
	public FormEletrodomestico() {
		super();
		
		//Criando campo de VOLTAGEM ao Formulário
		JLabel voltagem = new JLabel("Voltagem");
		voltagem.setBounds(150, 220, 200, 100);
		voltagem.setFont(new Font("Serif", Font.PLAIN, 30));
		voltagemInput = new JTextField(20);
		voltagemInput.setBounds(310, 260, 150, 30);
		voltagemInput.setFont(new Font("Serif", Font.PLAIN, 30));
		
		//Criando botão para voltar para o menu
		botaoVoltar.setBounds(150, 360, 150, 40);
		
		//Criando botão para registro de ELETRODOMESTICO
		botaoRegister.setBounds(310, 360, 150, 40);
		botaoRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				//Criando texto para ser adicionado no painel
				JLabel check = new JLabel();
				check.setFont(new Font("Serif", Font.PLAIN, 30));
				
				try {
					int id = Integer.parseInt(idInput.getText());
					String nome = nomeInput.getText();
					double preco = Double.parseDouble(precoInput.getText());
					int quantidade = Integer.parseInt(quantidadeInput.getText());
					int voltagem = Integer.parseInt(voltagemInput.getText());
					
					Main.registrar(new ProdutoEletrodomestico(Main.estoque, id, TipoProduto.ELETRODOMESTICO, nome, preco, quantidade, voltagem));
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
					exception.printStackTrace();
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
		
		//Adiciona campos adicionais ao formulário básico
		frame.add(voltagem);
		frame.add(voltagemInput);
		frame.add(botaoVoltar);
		frame.add(botaoRegister);
		
	}
	
	

}

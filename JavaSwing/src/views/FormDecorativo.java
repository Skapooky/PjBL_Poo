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

public class FormDecorativo extends BasicForm{

	private String[] options = {"Infatil", "Juvenil", "Adulta"};
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FormDecorativo() {
		
		erros.setBounds(190, 500, 220, 50);
		
		//Criando botão para voltar para o menu
		botaoVoltar.setBounds(150, 440, 150, 40);
		
		botaoRegister.setBounds(310, 440, 150, 40);
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
					String cor = corInput.getText();
					String faixaEtaria = (String) faixaEtariaInput.getSelectedItem(); 
					
					Main.registrar(new ProdutoDecorativo(Main.estoque, id, TipoProduto.DECORATIVO, nome, preco, quantidade, material, cor, faixaEtaria));
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
				
		//Adicionar campo de COR ao Formulário
		JLabel cor = new JLabel("Cor");
		cor.setBounds(150, 260, 200, 100);
		cor.setFont(new Font("Serif", Font.PLAIN, 30));
		corInput = new JTextField(20);
		corInput.setBounds(310, 300, 150, 30);
		corInput.setFont(new Font("Serif", Font.PLAIN, 30));
		
		//Adiciona campo FAIXA ETÁRIA ao Formulário
		JLabel faixaEtaria = new JLabel("Faixa etária");
		faixaEtaria.setBounds(150, 300, 200, 100);
		faixaEtaria.setFont(new Font("Serif", Font.PLAIN, 30));
		faixaEtariaInput = new JComboBox(options);
		faixaEtariaInput.setBounds(310, 340, 150, 30);
		faixaEtariaInput.setFont(new Font("Serif", Font.PLAIN, 20));
		
		frame.add(material);
		frame.add(materialInput);
		frame.add(cor);
		frame.add(corInput);
		frame.add(faixaEtaria);
		frame.add(faixaEtariaInput);
		frame.add(botaoVoltar);
		frame.add(botaoRegister);
		
	}
}

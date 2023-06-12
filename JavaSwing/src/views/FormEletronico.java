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

public class FormEletronico extends BasicForm{

	public FormEletronico() {
		super();
		
		//Criando botão para voltar para o menu
		botaoVoltar.setBounds(150, 380, 150, 40);
				
		//Criando botão para registro de ELETRODOMESTICO
		botaoRegister.setBounds(310, 380, 150, 40);
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
					String fabricante = fabricanteInput.getText();
					int anoFabricado = Integer.parseInt(anoInput.getText());
					
					Main.registrar(new ProdutoEletronico(Main.estoque, id, TipoProduto.ELETRONICO, nome, preco, quantidade, anoFabricado, fabricante));
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
		
		//Adicionar campo de FABRICANTE ao Formulário
		JLabel fabricante = new JLabel("Fabricante");
		fabricante.setBounds(150, 220, 200, 100);
		fabricante.setFont(new Font("Serif", Font.PLAIN, 30));
		fabricanteInput = new JTextField(20);
		fabricanteInput.setBounds(310, 260, 150, 30);
		fabricanteInput.setFont(new Font("Serif", Font.PLAIN, 30));
		
		//Adicionar campo de ANO FRABRICAÇÃO ao Formulário
		JLabel ano = new JLabel("Ano fabricação");
		ano.setBounds(150, 260, 200, 100);
		ano.setFont(new Font("Serif", Font.PLAIN, 25));
		anoInput = new JTextField(20);
		anoInput.setBounds(310, 300, 150, 30);
		anoInput.setFont(new Font("Serif", Font.PLAIN, 30));
		
		
		frame.add(botaoVoltar);
		frame.add(botaoRegister);
		frame.add(fabricante);
		frame.add(fabricanteInput);
		frame.add(ano);
		frame.add(anoInput);
		
	}
}

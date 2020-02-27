package br.senai.sp.informatica.introducao;

import java.awt.Dimension;

import javax.swing.JFrame;

public class TelaExemplo {
	public static void main(String[] args) {
		JFrame tela = new JFrame();
		tela.setTitle("Teste");
		tela.setPreferredSize(new Dimension(200, 200));
		tela.pack();
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
	}
}

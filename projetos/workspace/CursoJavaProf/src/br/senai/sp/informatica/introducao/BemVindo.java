package br.senai.sp.informatica.introducao;

import javax.swing.JOptionPane;

public class BemVindo {
	public static void main(String[] args) {
		// Ler o nome do usuário
		String nome = JOptionPane.showInputDialog("Informe o seu nome");
		// Mostrar a mensagem de boas vindas
		JOptionPane.showMessageDialog(null, "Bem Vindo, " + nome);
	}
}

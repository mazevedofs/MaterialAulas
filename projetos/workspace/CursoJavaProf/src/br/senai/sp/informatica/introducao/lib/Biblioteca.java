package br.senai.sp.informatica.introducao.lib;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Biblioteca {
	private Biblioteca() {}
	
	public static Component montaCampo(String label, JComponent campo) {
		JPanel painel = new JPanel(
				new FlowLayout(FlowLayout.LEADING, 5, 5));
		painel.add(new JLabel(label));
		painel.add(campo);
		return painel;
	}

	public static Component montaBotoes(ActionListener tela, JButton ... botoes) {
		JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		Arrays.stream(botoes)
			.forEach(botao -> {
				botao.addActionListener(tela);
				painel.add(botao);
			});
		return painel;
	}
	
	public static Component montaBotoes(TelaComAcao tela, BotaoPadrao ... botoes) {
		JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		Arrays.stream(botoes)
			.forEach(botao -> {
				JButton oBotao = new JButton(botao.toString());
				oBotao.addActionListener(tela);
				painel.add(oBotao);
				
				if(botao.isPadrao())
					tela.getRootPane().setDefaultButton(oBotao);
			});
		return painel;
	}
}

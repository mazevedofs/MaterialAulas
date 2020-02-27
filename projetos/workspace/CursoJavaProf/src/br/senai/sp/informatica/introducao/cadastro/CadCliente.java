package br.senai.sp.informatica.introducao.cadastro;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.senai.sp.informatica.introducao.lib.Biblioteca;
import br.senai.sp.informatica.introducao.lib.BotaoPadrao;
import br.senai.sp.informatica.introducao.lib.TelaComAcao;

@SuppressWarnings("serial")
public class CadCliente extends TelaComAcao {
	private JTextField tfNome = new JTextField(35);
	private JTextField tfEmail = new JTextField(40);
	private JTextField tfFone = new JTextField(15);
	
	private enum Acao implements BotaoPadrao {
		Salvar(true), Listar, Sair;
		
		private boolean padrao = false;
		
		private Acao() {}
		
		private Acao(boolean padrao) {
			this.padrao = padrao;
		}
		
		@Override
		public boolean isPadrao() {
			return padrao;
		}
	}
	
	private List<Cliente> cadastro = new ArrayList<>();
	
	public CadCliente() {
		setTitle("Cadastro de Clientes");
		setContentPane(montaTela());
		// Ajusta os componentes da tela
		// nos seus tamanhos ideais
		pack();
		// impede a mudança no tamanho da tela
		setResizable(false);
		// Definir como será finalizado o programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Centralizar a janela da aplicação na tela do computador
		setLocationRelativeTo(null);
		// Apresenta a janela 
		setVisible(true);
	}

	private Container montaTela() {
		JPanel painel = new JPanel(new GridLayout(4, 1));
		painel.add(Biblioteca.montaCampo("Nome", tfNome));
		painel.add(Biblioteca.montaCampo("E-Mail", tfEmail));
		painel.add(Biblioteca.montaCampo("Fone", tfFone));
		painel.add(Biblioteca.montaBotoes(this, Acao.values()));
		return painel;
	}

//	private Component montaCampo(String label, JTextField campo) {
//		JPanel painel = new JPanel(
//				new FlowLayout(FlowLayout.LEADING, 5, 5));
//		painel.add(new JLabel(label));
//		painel.add(campo);
//		return painel;
//	}

//	private Component montaBotoes(ActionListener lstn, Acao ... botoes) {
//		JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
//		Arrays.stream(botoes)
//			.forEach(botao -> {
//				JButton oBotao = new JButton(botao.toString());
//				oBotao.addActionListener(lstn);
//				painel.add(oBotao);
//				
//				if(botao.isPadrao())
//					CadCliente.this.getRootPane().setDefaultButton(oBotao);
//			});
//		return painel;
//	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		Object botao = evento.getActionCommand();
		
		if(botao.equals(Acao.Salvar.toString())) {
			Cliente oCliente = new Cliente();
			
			oCliente.setNome(tfNome.getText());
			oCliente.setEmail(tfEmail.getText());
			oCliente.setTelefone(tfFone.getText());
			
			cadastro.add(oCliente);
			
			tfNome.setText("");
			tfEmail.setText("");
			tfFone.setText("");
			tfNome.requestFocus();
		} else if(botao.equals(Acao.Listar.toString())) {
			JOptionPane.showMessageDialog(this,
				cadastro.stream()
					.map(Cliente::toString)
					.collect(Collectors.joining("\n")));
		
		} else {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(CadCliente::new);
	}
}


















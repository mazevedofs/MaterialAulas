package br.senai.sp.informatica.introducao.pedido;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.senai.sp.informatica.introducao.lib.Biblioteca;

@SuppressWarnings("serial")
public class CadItem extends JDialog implements ActionListener {
	private JTextField tfProduto = new JTextField(15);
	private JTextField tfDescr = new JTextField(30);
	private JTextField tfQuant = new JTextField(10);
	private JTextField tfValor = new JTextField(10);
	
	private JButton btSalvar = new JButton("Salvar");
	private JButton btFechar = new JButton("Fechar");

	private NumberFormat formatador =
				NumberFormat.getNumberInstance();
	
	private ItemDePedido item;
	
	public CadItem(ItemDePedido item) {
		this.item = item;
		formatador.setMaximumFractionDigits(2);
		formatador.setMinimumFractionDigits(2);
		
		// Para o Dialogo bloquear a tela anterior
		setModal(true);
		
		setTitle("Cadastro de Item");
		setContentPane(montaTela());
		// Ajusta os componentes da tela
		// nos seus tamanhos ideais
		pack();
		// Definir como será finalizado o programa
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		// Centralizar a janela da aplicação na tela do computador
//		setLocationRelativeTo(null);
//		// Apresenta a janela 
//		setVisible(true);
	}

	private Container montaTela() {		
		JPanel painel = new JPanel(new GridLayout(5, 1));
		painel.add(Biblioteca.montaCampo("Produto", tfProduto));
		painel.add(Biblioteca.montaCampo("Descr.", tfDescr));
		painel.add(Biblioteca.montaCampo("Qtd.", tfQuant));
		painel.add(Biblioteca.montaCampo("Valor Unit.", tfValor));
		painel.add(Biblioteca.montaBotoes(this, btSalvar, btFechar));
		
		getRootPane().setDefaultButton(btSalvar);
		return painel;
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		Object botao = evento.getSource();
		
		try {
			if(botao.equals(btSalvar)) {
				item.setProduto(tfProduto.getText());
				item.setDescricao(tfDescr.getText());
				item.setQuantidade(Integer.parseInt(tfQuant.getText()));
				item.setValorUnitario(
						formatador.parse(tfValor.getText()).doubleValue() );
			}
			
			setVisible(false);
		} catch (ParseException ex) {
			JOptionPane.showMessageDialog(this, "Valor Inválido!");
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Quantidade Inválida!");
		}
	}
}

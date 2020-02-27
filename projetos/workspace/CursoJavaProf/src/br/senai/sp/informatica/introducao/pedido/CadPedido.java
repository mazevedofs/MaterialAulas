package br.senai.sp.informatica.introducao.pedido;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.senai.sp.informatica.introducao.lib.Biblioteca;

@SuppressWarnings("serial")
public class CadPedido extends JFrame implements ActionListener {
	private JTextField tfNumero = new JTextField(10);
	private JTextField tfData = new JTextField(12);
	
	private JButton btSalvar = new JButton("Salvar");
	private JButton btListar = new JButton("Listar");
	private JButton btSair = new JButton("Sair");
	private JButton btAdicionar = new JButton(" + ");
	
	private DateTimeFormatter formatador = 
			DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//TODO: Verificar o erro com a utilização do
	//      .withResolverStyle(ResolverStyle.STRICT);
	
	private List<Pedido> cadastro = new ArrayList<>();
	private List<ItemDePedido> itens = new ArrayList<>();
	private ItemModel model = new ItemModel(itens);
	private JTable tabela = new JTable(model);
	
	private ItemDePedido item = new ItemDePedido();
	
	public CadPedido() {
		setTitle("Cadastro de Pedidos");
		setContentPane(montaTela());
		// Definir o tamanho padrão para a janela
		setPreferredSize(new Dimension(500,400));
		// Ajusta os componentes da tela
		// nos seus tamanhos ideais
		pack();
		// Definir como será finalizado o programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Centralizar a janela da aplicação na tela do computador
		setLocationRelativeTo(null);
		// Apresenta a janela 
		setVisible(true);
	}

	private Container montaTela() {
		btAdicionar.addActionListener(this);
		JPanel tela = new JPanel(new BorderLayout());
		tela.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel painel = new JPanel(new GridLayout(3, 1));
		painel.add(Biblioteca.montaCampo("Número", tfNumero));
		painel.add(Biblioteca.montaCampo("Data", tfData));
		painel.add(Biblioteca.montaCampo("Adiciona Itens", btAdicionar));
		tela.add(painel, BorderLayout.NORTH);
		
		tela.add(new JScrollPane(tabela), BorderLayout.CENTER);
		
		tela.add(Biblioteca.montaBotoes(this, btSalvar, btListar, btSair),
				BorderLayout.SOUTH);
		
		getRootPane().setDefaultButton(btSalvar);
		return tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		Object botao = evento.getSource();
		
		if(botao.equals(btSalvar)) {
			Pedido oPedido = new Pedido();
			
			oPedido.setNumero( Integer.parseInt( tfNumero.getText() ) );
			oPedido.setData( LocalDate.parse(tfData.getText(), formatador) );
			oPedido.setItens(itens);
			
			cadastro.add(oPedido);
			
			tfNumero.setText("");
			tfData.setText("");
			tfNumero.requestFocus();
			
			itens = new ArrayList<>();
			model.setItens(itens);
		} else if(botao.equals(btListar)) {
			JOptionPane.showMessageDialog(this,
				cadastro.stream()
					.map(Pedido::toString)
					.collect(Collectors.joining("\n")));

		} else if(botao.equals(btAdicionar)) {
			CadItem tela = new CadItem(item);
			tela.setLocationRelativeTo(this);
			tela.setVisible(true);
		
			if(item.getProduto() != null) {
				model.adiciona(item);
				item = new ItemDePedido();
			}
		} else {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(CadPedido::new);
	}
}


















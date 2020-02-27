package br.senai.sp.informatica.introducao.pedido;

import java.text.NumberFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ItemModel extends AbstractTableModel {
	private String[] titulos = {
		"Produto", "Descr.", "Qtd", "Valor Unit.", "Total"
	};
	private NumberFormat formatador = NumberFormat.getNumberInstance();
	private List<ItemDePedido> itens;
	
	public ItemModel(List<ItemDePedido> itens) {
		this.itens = itens;
		formatador.setMaximumFractionDigits(2);
		formatador.setMinimumFractionDigits(2);
	}
	
	public void setItens(List<ItemDePedido> itens) {
		this.itens = itens;
		fireTableDataChanged();
	}
	
	public void adiciona(ItemDePedido item) {
		itens.add(item);
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		return itens.size();
	}

	@Override
	public int getColumnCount() {
		return titulos.length;
	}

	@Override
	public String getColumnName(int coluna) {
		return titulos[coluna];
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		ItemDePedido item = itens.get(linha);
		Object valor = null;
		
		switch (coluna) {
		case 0:
			valor = item.getProduto();
			break;
		case 1:
			valor = item.getDescricao();
			break;
		case 2:
			valor = item.getQuantidade();
			break;
		case 3:
			valor = formatador.format(item.getValorUnitario());
			break;
		case 4:
			valor = formatador.format(item.getTotal());
			break;
		}
		
		return valor;
	}

}























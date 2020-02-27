package br.senai.sp.informatica.introducao.pedido;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Pedido {
	private int numero;
	private LocalDate data;
	private List<ItemDePedido> itens;
	
	public double getTotal() {
		return itens.stream()
				.map(ItemDePedido::getTotal)
				.reduce((total, valor) -> total += valor)
				.orElse(0d);
		
//		double total = 0;
//		for(ItemDePedido item : itens) {
//			double valor = item.getTotal();
//			total += valor;
//		}
//		return total;
	}

	@Override
	public String toString() {
//		String listaDeItens = "";
//		for (ItemDePedido item : itens) {
//			listaDeItens += item + "\n";
//		}
		
		return "Nº: " + numero + " Data: " + data + "\nItens\n" + 
				itens.stream()
					.map(ItemDePedido::toString)
					.collect(Collectors.joining("\n")) +
				"\nTotal: " + getTotal();
	}	
}

@Data
class ItemDePedido {
	private String produto;
	private String descricao;
	private int quantidade;
	private double valorUnitario;
	
	public double getTotal() {
		return quantidade * valorUnitario;
	}

	@Override
	public String toString() {
		return "produto: " + produto + " descricao: " + 
				descricao + " quantidade: " + quantidade + 
				" valor Unitario: "
				+ valorUnitario +  " total: " + getTotal();
	}
}
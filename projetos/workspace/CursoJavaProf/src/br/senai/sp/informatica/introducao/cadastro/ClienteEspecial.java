package br.senai.sp.informatica.introducao.cadastro;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClienteEspecial extends Cliente {
	private double renda;
	
	@Override
	public String toString() {
		return super.toString() + " Renda: " + renda;
	}

	
	public static void main(String[] args) {
		Cliente c = new ClienteEspecial();
		
		System.out.println(carregaCliente(c));
	}
	
	public static Cliente carregaCliente(Cliente c) {
		if(c instanceof ClienteEspecial) {
			System.out.println("Especial");
			
			ClienteEspecial e = (ClienteEspecial)c;
			
			e.setNome("Fulano");
			e.setEmail("fulano@gmail.com");
			e.setTelefone("1234-2344");
			e.setRenda(2500);
		} else {
			System.out.println("Comum");
			
			c.setNome("Fulano");
			c.setEmail("fulano@gmail.com");
			c.setTelefone("1234-2344");
		}
		
		return c;
	}



}

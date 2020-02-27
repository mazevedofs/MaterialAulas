package br.senai.sp.informatica.introducao;

import lombok.Data;

public class ExemploInteiro {
	public static void main(String[] args) {
		int i = 10;
		Integer j = 10;
		String k = "10";
		Cliente c = new Cliente();
		c.setNome("Joca");
		c.setEmail("joca@gmail.com");
		c.setIdade(34);
		
		Cliente c2 = new Cliente();
		c2.setNome("Zita");
		c2.setEmail("zita@hotmail.com");
		c2.setIdade(25);
		
		System.out.println(c + "\n" + c2);
		
		System.out.println(c.getNome());
		System.out.println(i + 1);
		System.out.println(j + 1);
		System.out.println(Integer.parseInt(k) + 1);
	}
}


// POJO
// Plain Old Java Object
@Data
class Cliente {
	private String nome;
	private String email;
	private int idade;
	
//	@Override
//	public String toString() {
//		return "Nome: " + nome + " E-Mail: " + email 
//				+ " Idade: " + idade;
//	}
}
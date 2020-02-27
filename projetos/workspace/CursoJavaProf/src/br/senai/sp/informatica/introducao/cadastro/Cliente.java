package br.senai.sp.informatica.introducao.cadastro;

import lombok.Data;

@Data
public class Cliente {
	private String nome;
	private String email;
	private String telefone;
	
	@Override
	public String toString() {
		return "Nome: " + nome + " E-Mail: " + email + " Fone: " + telefone;
	}
}

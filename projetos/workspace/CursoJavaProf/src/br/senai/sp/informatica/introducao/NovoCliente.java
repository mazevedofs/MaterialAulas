package br.senai.sp.informatica.introducao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovoCliente {
	private String nome;
	private String email;
	private int idade;
//
//	public NovoCliente() {
//		super();
//	}
//	
//	public NovoCliente(String nome, String email, int idade) {
//		super();
//		this.nome = nome;
//		this.email = email;
//		this.idade = idade;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public int getIdade() {
//		return idade;
//	}
//
//	public void setIdade(int idade) {
//		this.idade = idade;
//	}
//
//	
	@Override
	public String toString() {
		return "nome: " + nome + " email: " + email + " idade: " + idade;
	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + idade;
//		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		NovoCliente other = (NovoCliente) obj;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (idade != other.idade)
//			return false;
//		if (nome == null) {
//			if (other.nome != null)
//				return false;
//		} else if (!nome.equals(other.nome))
//			return false;
//		return true;
//	}
//
}

package br.senai.sp.informatica.introducao;

public class ClasseObjeto {
	String texto = "1 texto";
	static int numero = 0;
	
	static {
		System.out.println("na Classe");
	}

	{
		System.out.println("antes do Construtor");
	}
	
	public ClasseObjeto() {
		System.out.println("no Construtor");
	}
	
	@Override
	public String toString() {
		return texto + " Nº " + numero;
	}
	
	public static void main(String[] args) {
		ClasseObjeto obj = new ClasseObjeto();
		obj.texto = "outro texto";
		System.out.println(obj);
		
		ClasseObjeto obj2 = new ClasseObjeto();
		obj2.texto = "meu texto";
		ClasseObjeto.numero = 1;
		System.out.println(obj2);
		
		System.out.println(obj);
	}
}

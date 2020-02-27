package br.senai.sp.informatica.introducao;

public class ExemploOperacao {
	public static void main(String[] args) {
		int var2 = 3;
		int var3 = 0;
		int var4 = 0;
		
		System.out.println("var2: " + var2 + " var3: " + var3);
		var3 = ++var2;
		System.out.println("var2: " + var2 + " var3: " + var3);
		
		System.out.println("var2: " + var2 + " var4: " + var4);
		var4 = var2++;
		System.out.println("var2: " + var2 + " var4: " + var4);
	}
}

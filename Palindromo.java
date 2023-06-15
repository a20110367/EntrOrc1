package num;

import java.text.Normalizer;

public class Palindromo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String frase = "Isaac no ronca así";
		frase = Normalizer.normalize(frase, Normalizer.Form.NFD);
		frase = frase.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		frase = frase.replaceAll("[\\¿\\?\\¡\\!\\s]",""); 
		frase = frase.toLowerCase();
		Palindromo palindromo = new Palindromo();
		palindromo.verificarPalindromo(frase);

	}
	/*
	public void verificarPalindromo(String frase) {
		frase.trim();
		int flag=0;
		for(int i=0;i<frase.length()/2;i++) {
			if(frase.toLowerCase().charAt(i)!=frase.toLowerCase().charAt((frase.length()-1)-i)) {
				flag=1;
				break;					
			}
		}
		if(flag==1)
			System.out.println("No es Palindromo");
		else
			System.out.println("Si es Palindromo");
			
	}*/
	
	public void verificarPalindromo(String frase) {
		frase.trim();
		char[] letras = frase.toCharArray();
		int flag=0;
		for(int i=0;i<letras.length/2;i++) {
			if(letras[i]!=letras[(letras.length-1)-i]) {
				flag=1;
				break;					
			}
		}		
			System.out.println(flag==1?"No es Palindromo":"Si es Palindromo");

	}
	
}



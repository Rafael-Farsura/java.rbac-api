package src;
public class Estrutura {
	public static void main(String[] args) {
		int nota = 85;

		if (nota >= 90) 
			System.out.println("Aprovado com excelencia");
		else if (nota >= 70) 
			System.out.println("Aprovado");
		else 
			System.out.println("Reprovado");
			

		for (int i = 1; i <= 10; i++) {
			System.out.println("Contagem: " + i);
		}

		
		int contador = 0;
		while (contador < 5) {
			System.out.println("loop: " + contador);
			contador++;
		}


		int[] numeros = { 1, 2, 3, 4, 5 };
		for (int n : numeros) {
			System.out.println("numeros:" + n);
		}
	}
}

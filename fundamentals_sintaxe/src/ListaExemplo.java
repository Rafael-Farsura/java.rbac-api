package src;
import java.util.ArrayList;
import java.util.HashMap;

public class ListaExemplo {
	public static void main(String[] args){
		ArrayList<String> nomes = new ArrayList<>();

		nomes.add("Rafael");
		nomes.add("Lucas");
		nomes.add("Rebecca");

		System.out.println("Lista: " + nomes);

		nomes.remove("Lucas");

		for (String nome : nomes) {
			System.out.println("Nome: " + nome);
		}


		HashMap<String, Integer> idades = new HashMap<>();
		
		idades.put("Rafael", 26);
		idades.put("Lucas", 26);
		idades.put("Rebecca", 25);

		System.out.println(idades.get("Maria"));
		for (String nome : idades.keySet()) {
			System.out.println(nome + " tem " + idades.get(nome) + " anos");
		}
	}
}
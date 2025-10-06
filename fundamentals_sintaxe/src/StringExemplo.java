package src;
public class StringExemplo {
    public static void main(String[] args) {
        String texto = "Java is awesome"; 

        System.out.println(texto.length());
        System.out.println(texto.toUpperCase());
        System.out.println(texto.toLowerCase());
        System.out.println(texto.contains("Java"));
        System.out.println(texto.replace("Java", "Python"));

        String[] partes = texto.split(" ");

        System.out.println("starting for \n");

        for (String palavra : partes) {
            System.out.println(palavra);
        }
    }
}

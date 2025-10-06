package src;
import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6);

        long pair = numeros.stream()
        .filter(n -> n % 2 == 0)
        .count();

        System.out.println("Pairs numbers quantity: " + pair);  

    }
}

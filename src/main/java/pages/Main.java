package pages;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        String generatedString = random.ints(97, 122 + 1)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString);
    }

}

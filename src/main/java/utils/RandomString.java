package utils;

import java.util.Random;

public class RandomString {

    // This method generates random alphabetic string of 10 chars
    // 97 is HTML numeric code for "a" char, 122 is HTML numeric code for "z" char
    public static String getRandomString() {
        Random random = new Random();
        return random.ints(97, 122 + 1)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}

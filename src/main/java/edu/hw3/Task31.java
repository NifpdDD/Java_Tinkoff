package edu.hw3;

public class Task31 {
    public static String atbashCipher(String text) {
        StringBuilder result = new StringBuilder();
        buildString(text, result);
        return result.toString();
    }

    private static void buildString(String text, StringBuilder result) {
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                changeLetter(result, c);
            } else {
                result.append(c);
            }
        }
    }

    private static void changeLetter(StringBuilder result, char c) {
        if (Character.isUpperCase(c)) {
            result.append((char) (155 - c));
        } else {
            result.append((char) (219 - c));
        }
    }
}

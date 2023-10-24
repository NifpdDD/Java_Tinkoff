package edu.hw3;

import org.jetbrains.annotations.NotNull;

public class Task1 {

    public String atbashCipher(@NotNull String text) {
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

    @SuppressWarnings("MagicNumber")
    private static void changeLetter(StringBuilder result, char c) {
        if (Character.isUpperCase(c)) {
            result.append((char) (155 - c));
        } else {
            result.append((char) (219 - c));
        }
    }

}

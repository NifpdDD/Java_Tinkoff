package edu.hw1;

import java.util.Objects;


public class Task5 {
    public Task5() {

    }

    public String fixString(String s) {
        Objects.requireNonNull(s);
        if (s.trim().isEmpty()) {
            return "Строка пустая или состоит из одних пробелов";
        } else {
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length - 1; i += 2) {
                char temp = charArray[i];
                charArray[i] = charArray[i + 1];
                charArray[i + 1] = temp;
            }
            return new String(charArray);
        }
    }
}

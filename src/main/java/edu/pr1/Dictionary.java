package edu.pr1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class Dictionary {
    static Random random = new Random();
    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    @NotNull String randomWord() {
        return this.words[random.nextInt(this.words.length)];
    }
}

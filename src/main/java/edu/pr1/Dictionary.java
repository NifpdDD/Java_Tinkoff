package edu.pr1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class Dictionary {
    private String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    static Random random = new Random();

    @NotNull String randomWord() {
        return this.words[random.nextInt(this.words.length)];
    }
}

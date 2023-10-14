package edu.pr1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DictionaryTest {

    @Test
    void random_word_should_return_valid_word() {
        String[] words = {"pivo", "beer", "cerveza", "bier"};
        Dictionary dictionary = new Dictionary(words);

        var rw = dictionary.randomWord();

        Assertions.assertThat(words).contains(rw);
    }
}

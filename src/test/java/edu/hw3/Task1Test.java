package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Task1Test {
    @ParameterizedTest
    @CsvSource({"Hello world!,Svool dliow!",
        "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler,Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"})
    void if_correct_word_should_return_expectedword(String word, String expectedWord) {
        var t = new Task1();

        var building = t.atbashCipher(word);

        Assertions.assertThat(building).isEqualTo(expectedWord);

    }

    @Test
    void if_space_should_return_space() {
        var t = new Task1();

        Assertions.assertThatThrownBy(() -> {
            t.atbashCipher(null);
        }).isInstanceOf(NullPointerException.class);

    }

}

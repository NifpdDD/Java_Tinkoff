package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

class Task2Test {

    static Arguments[] inputBrackets() {
        return new Arguments[] {
            Arguments.of("()()()", new String[]{"()", "()", "()"}),
            Arguments.of("((()))", new String[]{"((()))"}),
            Arguments.of("((()))(())()()(()())", new String[]{"((()))", "(())", "()", "()", "(()())"}),
            Arguments.of("((())())(()(()()))", new String[]{"((())())", "(()(()()))"})
        };
    }
    @ParameterizedTest
    @MethodSource("inputBrackets")
    void if_corect_brackets_should_return_mass(String input, String[] expectedOutput) {
        var t = new Task2();

        var bracketsMas = t.groupBrackets(input.toCharArray());

        Assertions.assertThat(bracketsMas).isEqualTo(expectedOutput);
    }

    @Test
    void if_not_corect_symbols_should_return_e() {
        var t = new Task2();

        Assertions.assertThatThrownBy(() -> {
            t.groupBrackets("LovePivo))))".toCharArray());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"((())))","()(", "' '"})
    void if_not_corect_brackets_should_return_e(String str) {
        var t = new Task2();

        Assertions.assertThatThrownBy(() -> {
            t.groupBrackets(str.toCharArray());
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void if_null_should_return_e() {
        var t = new Task2();

        Assertions.assertThatThrownBy(() -> {
            t.groupBrackets(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Task7Test {
    @ParameterizedTest
    @CsvSource({"110", "000", "1101111111111", "100000000000"})
    void if_is_legnth_more_than_3_and_3_pos_equals_0_should_return_true(String str) {
        var task7 = new Task7();

        boolean result = task7.isLegnthMoreThan3And3PosEquals0(str);

        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"111", "001", "a10", "111111111111"})
    void if_is_legnth_more_than_3_and_3_pos_equals_0_should_return_false(String str) {
        var task7 = new Task7();

        boolean result = task7.isLegnthMoreThan3And3PosEquals0(str);

        Assertions.assertThat(result).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"111", "000", "111", "011111111110"})
    void if_is_begin_and_end_with_the_same_char_should_retun_true(String str) {
        var task7 = new Task7();

        boolean result = task7.isBeginAndEndWithTheSameChar(str);

        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"110", "001", "011", "a1111111111a"})
    void if_isnot_begin_and_end_with_the_same_char_should_retun_false(String str) {
        var task7 = new Task7();

        boolean result = task7.isBeginAndEndWithTheSameChar(str);

        Assertions.assertThat(result).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"1", "11", "01", "011"})
    void if_is_length_between_1_and_3_return_true(String str) {
        var task7 = new Task7();

        boolean result = task7.isLengthBetween1and3(str);

        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1000", "a11", "0111111"})
    void if_isnot_length_between_1_and_3_return_false(String str) {
        var task7 = new Task7();

        boolean result = task7.isLengthBetween1and3(str);

        Assertions.assertThat(result).isFalse();
    }
}

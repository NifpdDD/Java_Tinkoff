package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class Task4Test {
    @ParameterizedTest
    @CsvSource({
        "1, I",
        "4, IV",
        "9, IX",
        "49, XLIX",
        "99, XCIX",
        "3999, MMMCMXCIX"
    })
    void if_correсt_arabic_number_should_return_correct_roman(int number, String expected) {
        var t4 = new Task4();
        String result = t4.convertToRoman(number);
        Assertions.assertThat(expected).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -2, 4001})
    void if_not_corrent_arabic_number_should_return_e(int number) {
        var t4 = new Task4();

        Assertions.assertThatThrownBy(() -> t4.convertToRoman(number)).isInstanceOf(IllegalArgumentException.class);
    }

}

package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Task5Test {

    @ParameterizedTest
    @CsvSource({"А123ВЕ777", "О777ОО177"})
    void if_russian_number_is_correct_return_true(String number) {
        var task5 = new Task5();

        boolean result = task5.isRussianNumber(number);

        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"123АВЕ777", "1А123ВГ777", "А123ВЕ7777"})
    void if_russian_number_isnt_correct_return_false(String number) {
        var task5 = new Task5();

        boolean result = task5.isRussianNumber(number);

        Assertions.assertThat(result).isFalse();
    }

}

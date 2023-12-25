package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task8Test {
    @ParameterizedTest @CsvSource({"101, true", "11111, true", "01010, true"})
    void if_it_has_odd_length_shoul_return_true(String str, boolean expected) {
        var tak8 = new Task8();

        boolean result = tak8.isLengthIsOdd(str);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest @CsvSource({"10, false", "1111, false", "010101, false"})
    void if_it_has_even_length_should_return_false(String str, boolean expected) {
        var tak8 = new Task8();

        boolean result = tak8.isLengthIsOdd(str);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"011, true", "1111, true", "1010, true"})
    void if_it_has_odd_length_and_start_with_0_or_even_length_and_start_with_1_should_return_true(
        String str, boolean expected
    ) {
        var tak8 = new Task8();

        boolean result = tak8.isLengthIsOddAndStartWith0OrLengthIsEvenAndStartWith1(str);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0111, false", "11110, false", "1010111, false"})
    void if_it_hasnt_odd_length_and_start_with_0_or_even_length_and_start_with_1_should_return_true(
        String str, boolean expected
    ) {
        var tak8 = new Task8();

        boolean result = tak8.isLengthIsOddAndStartWith0OrLengthIsEvenAndStartWith1(str);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"011100, true", "000, true", "000000111111, true"})
    void if_is_number_of_0_mod_3_equals_0_should_return_true(
        String str, boolean expected
    ) {
        var tak8 = new Task8();

        boolean result = tak8.isNumberOf0mod3equals0(str);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0111000, false", "0000, false", "0000001110111,false"})
    void if_is_number_of_0_mod_3_not_equals_0_should_return_false(
        String str, boolean expected
    ) {
        var tak8 = new Task8();

        boolean result = tak8.isNumberOf0mod3equals0(str);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1010101010, true", "11111, true", "00011,true"})
    void if_is_number_is_not_equal_111_or_11_should_return_true(
        String str, boolean expected
    ) {
        var tak8 = new Task8();

        boolean result = tak8.isNumberIsNotEqual111or11(str);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"111, false", "11, false"})
    void if_is_number_is_equal_111_or_11_should_return_false(
        String str, boolean expected
    ) {
        var tak8 = new Task8();

        boolean result = tak8.isNumberIsNotEqual111or11(str);

        assertThat(result).isEqualTo(expected);
    }

}

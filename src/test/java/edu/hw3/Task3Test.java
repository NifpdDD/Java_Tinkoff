package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task3Test {
    static <T> Arguments[] inputStr() {
        return new Arguments[] {
            Arguments.of(Arrays.asList("a", "bb", "a", "bb"), Map.of("bb", 2, "a", 2)),
            Arguments.of(Arrays.asList("this", "and", "that", "and"), Map.of("that", 1, "and", 2, "this", 1)),
            Arguments.of(Arrays.asList("код", "код", "код", "bug"), Map.of("код", 3, "bug", 1)),
            Arguments.of(Arrays.asList(1, 1, 2, 2), Map.of(1, 2, 2, 2)),
            Arguments.of(Arrays.asList(1, "Код"), Map.of(1, 1, "Код", 1))
        };
    }

    @ParameterizedTest
    @MethodSource("inputStr") <T> void should_return_freq(List<T> input, Map<T, Integer> expected) {
        var t = new Task3();

        var freq = t.freqDict(input);

        Assertions.assertThat(freq).isEqualTo(expected);
    }

    @Test
    void if_empty_should_return_size_0() {
        var t = new Task3();

        var freq = t.freqDict(new ArrayList<>());
        var sizeFreq = freq.size();

        Assertions.assertThat(sizeFreq).isZero();
    }

    @Test
    void if_null_should_return_e() {
        var t = new Task3();

        Assertions.assertThatThrownBy(() -> t.freqDict(new ArrayList<>(null))).isInstanceOf(NullPointerException.class);

    }

}

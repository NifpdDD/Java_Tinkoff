package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ParserTest {
    static Arguments[] corrrectDateFormats() {
        return new Arguments[] {
            Arguments.of("2020-10-10", Optional.of(LocalDate.of(2020, 10, 10))),
            Arguments.of("2020-12-2", Optional.of(LocalDate.of(2020, 12, 2))),
            Arguments.of("1/3/1976", Optional.of(LocalDate.of(1976, 3, 1))),
            Arguments.of("1/3/20", Optional.of(LocalDate.of(2020, 3, 1))),
            Arguments.of("tomorrow", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("yesterday", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("today", Optional.of(LocalDate.now())),
            Arguments.of("1 day ago", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("35 days ago", Optional.of(LocalDate.now().minusDays(35)))
        };
    }

    @ParameterizedTest
    @MethodSource("corrrectDateFormats()")
    void if_input_is_in_correct_format_should_return_local_date(String input, Optional<LocalDate> expected) {
        var parser = Parser.link(
            new CheckRussiaDateFormat(),
            new CheckEuropeDateFormat(),
            new CheckTextFormat(),
            new CheckAgoFormat()
        );

        var result = parser.parse(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Arguments[] incorrrectDateFormats() {
        return new Arguments[] {
            Arguments.of("pivo", Optional.empty()),
            Arguments.of("2020112-2", Optional.empty()),
            Arguments.of("1/3/1912312312376", Optional.empty()),
            Arguments.of("1/123123123/20", Optional.empty()),
            Arguments.of("tomorrrrrrrrrow", Optional.empty()),
            Arguments.of("yestttttterday", Optional.empty()),
            Arguments.of("today)))))))", Optional.empty()),
            Arguments.of("1 day agoooo", Optional.empty()),
            Arguments.of("35 dayssssss ago", Optional.empty()),
        };
    }

    @ParameterizedTest
    @MethodSource("incorrrectDateFormats()")
    void if_input_is_in_incorrect_format_should_return_local_date(String input, Optional<LocalDate> expected) {
        var parser = Parser.link(
            new CheckRussiaDateFormat(),
            new CheckEuropeDateFormat(),
            new CheckTextFormat(),
            new CheckAgoFormat()
        );

        var result = parser.parse(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

}

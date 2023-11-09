package edu.hw5;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2Test {
    @Test
    void if_get_valid_year_returns_friday_13_list() {
        var task2 = new Task2();
        var year=2024;

        List<LocalDate> friday13List = task2.getAll13Friday(year);

        Assertions.assertThat(friday13List).hasSize(2);
        Assertions.assertThat(friday13List).contains(LocalDate.of(2024, Month.SEPTEMBER, 13))
            .contains(LocalDate.of(2024, Month.DECEMBER, 13));
    }

    @Test
    void if_get_date_should_retur_next13_friday() {
        var task2 = new Task2();
        var date = LocalDate.of(2024, Month.JANUARY, 13);

        LocalDate nextFriday = task2.getNext13Frifday(date.toString());

        Assertions.assertThat(nextFriday).isEqualTo(LocalDate.of(2024, Month.SEPTEMBER, 13));
    }
}

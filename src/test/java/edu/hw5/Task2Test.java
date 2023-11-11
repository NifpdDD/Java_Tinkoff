package edu.hw5;

import java.time.LocalDate;
import java.time.Month;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2Test {

    @Test
    void if_get_date_should_retur_next13_friday() {
        var task2 = new Task2();
        var date = LocalDate.of(2024, Month.JANUARY, 13);

        LocalDate nextFriday = task2.getNext13Frifday(date.toString());

        Assertions.assertThat(nextFriday).isEqualTo(LocalDate.of(2024, Month.SEPTEMBER, 13));
    }
}

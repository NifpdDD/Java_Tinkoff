package edu.hw5;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {

    @Test
    void if_corrrect_average_visit_duration_should_return_average_visit_duration() {
        var task1 = new Task1();
        List<String> times = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        );
        String expected = "3:40";

        String actual = task1.getAverageVisitDuration(times);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void if_notcorrrect_average_visit_duration_should_return_e() {
        var task1 = new Task1();
        List<String> times = List.of(
            "2022-03-12, 24:20 - 2022-03-12, 25:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        );

        Assertions.assertThatThrownBy(() -> task1.getAverageVisitDuration(times))
            .isInstanceOf(IllegalArgumentException.class);
    }

}

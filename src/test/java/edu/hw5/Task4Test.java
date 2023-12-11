package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task4Test {

    @Test
    void if_password_is_correct_return_true() {
        Task4 task4 = new Task4();
        var password = "$%*|";

        boolean result = task4.isPassword(password);

        Assertions.assertThat(result).isTrue();

    }

    @Test
    void if_password_is_not_correct_return_false() {
        Task4 task4 = new Task4();
        var password = "123";

        boolean result = task4.isPassword(password);

        Assertions.assertThat(result).isFalse();
    }
}

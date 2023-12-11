package edu.hw7.task2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MultiFactorialTest {
    @Test
    void try_multithread_factorial() {
        var multiFactorial = new MultiFactorial(15);

        var value = multiFactorial.countFactorial();

        Assertions.assertThat(value).isEqualTo(1307674368000L);
    }
}

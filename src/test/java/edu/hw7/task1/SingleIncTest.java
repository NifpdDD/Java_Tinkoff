package edu.hw7.task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SingleIncTest {

    @Test
    void try_inc() {
        var value = new SingleInc();

        for (int i = 0; i < 10; i++) {
            value.inc();
        }

        Assertions.assertThat(value.getValue()).isEqualTo(10);
    }
}

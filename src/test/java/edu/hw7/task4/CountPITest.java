package edu.hw7.task4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import static org.junit.jupiter.api.Assertions.*;

class CountPITest {

    public static final int ITERS = 1000000;

    @Test
    void if_count_should_return_pi() {
        var count = new CountPI(ITERS);

        var result = count.count();

        Assertions.assertThat(result-Math.PI).isLessThan(0.01);
    }

    @Test
    void if_count_multi_thread_should_return_pi() throws ExecutionException, InterruptedException {
        var count = new CountPI(ITERS);

        var result = count.countMultiThread((byte) 4);


        Assertions.assertThat(result-Math.PI).isLessThan(0.01);
    }
}

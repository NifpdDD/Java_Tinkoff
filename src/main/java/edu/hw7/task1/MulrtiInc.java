package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;

@Getter public class MulrtiInc {
    private AtomicInteger value = new AtomicInteger();

    public void inc() {
        value.incrementAndGet();
    }
}

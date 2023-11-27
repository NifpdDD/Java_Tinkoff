package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;

public class MulrtiInc {
    @Getter private AtomicInteger value = new AtomicInteger();

    public void inc() {
        value.incrementAndGet();
    }
}

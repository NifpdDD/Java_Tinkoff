package edu.hw7;

import lombok.Getter;
import java.util.concurrent.atomic.AtomicInteger;

public class MulrtiInc {
    @Getter private AtomicInteger value;

   public void inc() {
       value.incrementAndGet();
   }
}

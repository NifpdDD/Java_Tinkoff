package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BackwardIteratorTest {
    @Test
    void should_return_back() {
        List<Integer> numbers = List.of(1, 2, 3);
        Iterator<Integer> iterator = new BackwardIterator<>(numbers);
        List<Integer> backNumbers = new ArrayList<>(3);

        while (iterator.hasNext()) {
            Integer number = iterator.next();
            backNumbers.add(number);
        }

        Assertions.assertThat(backNumbers).isEqualTo(numbers.reversed());

    }
}

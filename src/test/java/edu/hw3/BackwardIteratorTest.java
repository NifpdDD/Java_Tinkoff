package edu.hw3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BackwardIteratorTest {
    @Test
    void should_return_back() {
        List<Integer> numbers = List.of(1, 2, 3);
        Iterator<Integer> iterator = new BackwardIterator<>(numbers);

        Integer number = iterator.next();

        Assertions.assertThat(numbers.get(2)).isEqualTo(number);

    }

    @Test
    void should_return_e() {
        List<Integer> numbers = new ArrayList<>();
        Iterator<Integer> iterator = new BackwardIterator<>(numbers);

        Assertions.assertThatThrownBy(() -> iterator.next()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void should_return_back_munis_1() {
        List<Integer> numbers = List.of(1, 2, 3);
        Iterator<Integer> iterator = new BackwardIterator<>(numbers);

        iterator.next();
        Integer number = iterator.next();

        Assertions.assertThat(numbers.get(1)).isEqualTo(number);

    }
}

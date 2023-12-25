package edu.hw3;

import java.util.TreeMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NullComparatorTest {

    @Test
    void if_null_should_insert_null() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator());

        tree.put(null, "test");

        Assertions.assertThat(tree).containsKey(null);
    }
}

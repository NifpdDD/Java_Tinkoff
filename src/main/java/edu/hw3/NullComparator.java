package edu.hw3;

import java.util.Comparator;

class NullComparator<T> implements Comparator<T> {
    @Override
    public int compare(T s1, T s2) {
        if (s1 == null && s2 == null) {
            return 0;
        }
        if (s1 == null) {
            return -1;
        }
        return 1;
    }
}

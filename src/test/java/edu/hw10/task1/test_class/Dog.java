package edu.hw10.task1.test_class;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;

public record Dog(@Min(5) @Max(20) int age, String name) {
}

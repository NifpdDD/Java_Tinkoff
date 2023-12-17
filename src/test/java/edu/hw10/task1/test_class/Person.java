package edu.hw10.task1.test_class;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import org.jetbrains.annotations.NotNull;

public class Person {
    private int age;
    private String name;
    public Person(
        @Min(5) @Max(90) int age,
        @NotNull String name
    ) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

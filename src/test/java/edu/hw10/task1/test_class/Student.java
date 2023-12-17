package edu.hw10.task1.test_class;

import java.util.Random;

public class Student extends Person {
    public Student(int age, String name) {
        super(age, name);
    }
    public static Student createStudent() {
        int age = new Random().nextInt(0,90);
        return new Student(age, "John");
    }
}

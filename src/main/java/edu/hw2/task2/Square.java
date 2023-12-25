package edu.hw2.task2;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(int size) {
        super(size, size);
    }

    public final Square setSize(int size) {
        return new Square(size);
    }
}

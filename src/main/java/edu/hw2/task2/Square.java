package edu.hw2.task2;

public class Square extends Rectangle {

    public final Rectangle setSize(int size) {
        return new Rectangle(size,size);
    }
}

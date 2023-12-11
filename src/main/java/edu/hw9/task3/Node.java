package edu.hw9.task3;

import lombok.Getter;

@Getter  public class Node {
    private int data;
    private Node[] children;

    public Node(int data, Node... children) {
        this.data = data;
        this.children = children;
    }
}

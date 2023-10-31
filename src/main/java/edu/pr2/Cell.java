package edu.pr2;

public record Cell(Type type) {
    public enum Type { WALL, PASSAGE }
}

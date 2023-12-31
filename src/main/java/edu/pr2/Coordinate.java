package edu.pr2;

import java.util.Objects;

public record Coordinate(int row, int col) {
    public Coordinate {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coordinate other)) {
            return false;
        }
        return Objects.equals(row, other.row) && Objects.equals(col, other.col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}


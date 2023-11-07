package edu.pr2;

import java.util.Objects;

public record Coordinate(int row, int col) {
    public Coordinate {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return Objects.equals(row, other.row) && Objects.equals(col, other.col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

}


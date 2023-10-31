package edu.pr2;

import java.util.Objects;

public record Coordinate(int row, int col) {
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

}


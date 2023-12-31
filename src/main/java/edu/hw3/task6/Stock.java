package edu.hw3.task6;

import java.util.Objects;

public class Stock {
    private final String name;
    private final int price;

    public Stock(String name, int price) {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stock other)) {
            return false;
        }
        return Objects.equals(name, other.name) && Objects.equals(price, other.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

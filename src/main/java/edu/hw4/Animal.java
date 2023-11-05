package edu.hw4;

import java.util.Objects;
import lombok.Builder;

@SuppressWarnings("MagicNumber")
@Builder
public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return age == animal.age && height == animal.height && weight == animal.weight && bites == animal.bites
            && Objects.equals(name, animal.name) && type == animal.type && sex == animal.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, sex, age, height, weight, bites);
    }

    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }
}

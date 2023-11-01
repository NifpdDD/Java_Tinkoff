package edu.hw4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalUtils {
    private AnimalUtils() {

    }

    public static List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static List<Animal> sortAnimalsByWeight(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).toList();
    }

    public static Map<Animal.Type, Integer> howManyAnimalsInType(List<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(
            Animal::type,
            Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
        ));
    }

    public static Animal longestName(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingInt(animal -> animal.name().length())).orElse(null);
    }

    public static Animal.Sex mostSex(List<Animal> animals) {
        var sex = animals.stream().collect(Collectors.groupingBy(Animal::sex,Collectors.counting()));
        var m = sex.getOrDefault(Animal.Sex.M,0L);
        var f = sex.getOrDefault(Animal.Sex.F,0L);
        return (m>f) ? Animal.Sex.M : Animal.Sex.F;

    }

}

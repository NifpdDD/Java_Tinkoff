package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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

    public static Animal.Sex mostPopularSex(List<Animal> animals) {
        var sex = animals.stream().collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));
        var m = sex.getOrDefault(Animal.Sex.M, 0L);
        var f = sex.getOrDefault(Animal.Sex.F, 0L);
        return (m > f) ? Animal.Sex.M : Animal.Sex.F;

    }

    public static Map<Animal.Type, Animal> theHeightestAnimalInEachType(List<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(
            Animal::type,
            Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingInt(Animal::height)),
                other -> other.orElse(null)
            )
        ));
    }

    public static Animal theOldestAnimal(List<Animal> animals, int k) {
        if (k < 0 || k > animals.size()) {
            throw new IllegalArgumentException();
        }
        var sortByAge = animals.stream().sorted(Comparator.comparingInt(Animal::age).reversed()).toList();
        return sortByAge.get(k);

    }

    public static Optional<Animal> theWeighestAnimalUnderK(List<Animal> animals, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException();
        }
        return animals.stream().filter(animal -> animal.height() < k).max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer sumOfPaws(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    public static List<Animal> animalsWithfPawsIsNotEqualToAge(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.paws() != animal.age()).toList();
    }

    public static List<Animal> canBiteAndHeightUpper100(List<Animal> animals) {
        final int minHeight = 100;
        return animals.stream().filter(animal -> animal.bites() && animal.height() > minHeight).toList();
    }

    public static int countAnimalsWhichWeightIsMoreThanHeight(List<Animal> animals) {
        return (int) animals.stream().filter(animal -> animal.weight() > animal.height()).count();
    }

    public static List<Animal> animalsWithMoreThanTwoWordsInName(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.name().split(" ").length > 2).toList();
    }

    public static boolean hasDogTallerThanK(List<Animal> animals, int k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }
        return animals.stream().allMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    public static Map<Animal.Type, Integer> animalsWeightWhichAgeIsInKtoByType(List<Animal> animals, int k, int l) {
        if (k > l || k < 0) {
            throw new IllegalArgumentException();
        }
        return animals.stream().filter(animal -> animal.age() > k && animal.age() < l)
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.summingInt(Animal::weight)
            ));
    }

    public static List<Animal> sortedAnimalsByTypeSexName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    public static boolean isSpidersBiteMoreThanDogs(List<Animal> animals) {
        long bitingSpiders = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites())
            .count();

        long bitingDogs = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites())
            .count();

        return bitingSpiders > bitingDogs;
    }

    public static Animal heaviestFishInLists(List<List<Animal>> animalLists) {
        return animalLists.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    public static Map<String, Set<ValidationError>> validationErrors(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(Animal::name, ValidationError::getValidationError));
    }

    public static Map<String, String> getValidationErrorMessages(List<Animal> animals) {
        var errors = validationErrors(animals);
        return errors.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream()
                    .map(ValidationError::getMessage)
                    .collect(Collectors.joining(", "))
            ));

    }

}

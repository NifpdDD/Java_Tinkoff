package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AnimalUtilsTest {
    @Test
    void get_sort_animals_by_height() {
        var animal1 = new Animal.AnimalBuilder().height(5).build();
        var animal2 = new Animal.AnimalBuilder().height(10).build();
        var animal3 = new Animal.AnimalBuilder().height(15).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        List<Animal> sortedAnimals = AnimalUtils.sortAnimalsByHeight(animals);

        Assertions.assertThat(sortedAnimals).isEqualTo(List.of(animal1, animal2, animal3));
    }

    @Test
    void sort_animals_by_weight() {
        var animal1 = new Animal.AnimalBuilder().weight(5).build();
        var animal2 = new Animal.AnimalBuilder().weight(10).build();
        var animal3 = new Animal.AnimalBuilder().weight(15).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        List<Animal> sortedAnimals = AnimalUtils.sortAnimalsByWeight(animals, 3);

        Assertions.assertThat(sortedAnimals).isEqualTo(List.of(animal3, animal2, animal1));
    }

    @Test
    void how_many_animals_in_type() {
        var animal1 = new Animal.AnimalBuilder().type(Animal.Type.DOG).build();
        var animal2 = new Animal.AnimalBuilder().type(Animal.Type.DOG).build();
        var animal3 = new Animal.AnimalBuilder().type(Animal.Type.SPIDER).build();
        var animal4 = new Animal.AnimalBuilder().type(Animal.Type.FISH).build();
        var animal5 = new Animal.AnimalBuilder().type(Animal.Type.CAT).build();

        List<Animal> animals = List.of(animal1, animal2, animal3, animal4, animal5);

        Assertions.assertThat(AnimalUtils.howManyAnimalsInType(animals))
            .isEqualTo(Map.of(Animal.Type.CAT, 1, Animal.Type.DOG, 2, Animal.Type.FISH, 1, Animal.Type.SPIDER, 1));
    }

    @Test
    void get_animal_with_longest_name() {
        var animal1 = new Animal.AnimalBuilder().name("Rex").build();
        var animal2 = new Animal.AnimalBuilder().name("Diego").build();
        var animal3 = new Animal.AnimalBuilder().name("SSSSSSSS").build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        Animal longestName = AnimalUtils.longestName(animals);

        Assertions.assertThat(longestName).isEqualTo(animal3);
    }

    @Test
    void get_most_popular_sex() {
        var animal1 = new Animal.AnimalBuilder().sex(Animal.Sex.M).build();
        var animal2 = new Animal.AnimalBuilder().sex(Animal.Sex.M).build();
        var animal3 = new Animal.AnimalBuilder().sex(Animal.Sex.F).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        Animal.Sex mostPopularSex = AnimalUtils.mostPopularSex(animals);

        Assertions.assertThat(mostPopularSex).isEqualTo(Animal.Sex.M);
    }

    @Test
    void the_heightest_animal_in_each_type() {
        var animal1 = new Animal.AnimalBuilder().height(5).type(Animal.Type.SPIDER).build();
        var animal2 = new Animal.AnimalBuilder().height(10).type(Animal.Type.DOG).build();
        var animal3 = new Animal.AnimalBuilder().height(15).type(Animal.Type.FISH).build();
        var animal4 = new Animal.AnimalBuilder().height(9).type(Animal.Type.SPIDER).build();
        var animal5 = new Animal.AnimalBuilder().height(15).type(Animal.Type.DOG).build();
        var animal6 = new Animal.AnimalBuilder().height(20).type(Animal.Type.FISH).build();

        List<Animal> animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6);
        Map<Animal.Type, Animal> typeAnimalMap = AnimalUtils.theHeightestAnimalInEachType(animals);

        Assertions.assertThat(typeAnimalMap)
            .isEqualTo(Map.of(Animal.Type.DOG, animal5, Animal.Type.FISH, animal6, Animal.Type.SPIDER, animal4));
    }

    @Test
    void the_oldest_animal() {
        var animal1 = new Animal.AnimalBuilder().age(5).build();
        var animal2 = new Animal.AnimalBuilder().age(10).build();
        var animal3 = new Animal.AnimalBuilder().age(15).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        Animal theOldestAnimal = AnimalUtils.theOldestAnimal(animals, 1);

        Assertions.assertThat(theOldestAnimal).isEqualTo(animal2);
    }

    @Test
    void the_weighest_animal_underk() {
        var animal1 = new Animal.AnimalBuilder().height(5).weight(7).build();
        var animal2 = new Animal.AnimalBuilder().height(10).weight(10).build();
        var animal3 = new Animal.AnimalBuilder().height(15).weight(15).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        var theWeighestAnimalUnderK = AnimalUtils.theWeighestAnimalUnderK(animals, 11);

        Assertions.assertThat(theWeighestAnimalUnderK).contains(animal2);
    }

    @Test
    void get_sum_of_Paws() {
        var animal1 = new Animal.AnimalBuilder().type(Animal.Type.DOG).build();
        var animal2 = new Animal.AnimalBuilder().type(Animal.Type.DOG).build();
        var animal3 = new Animal.AnimalBuilder().type(Animal.Type.FISH).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        var sumOfPaws = AnimalUtils.sumOfPaws(animals);

        Assertions.assertThat(sumOfPaws).isEqualTo(8);
    }

    @Test
    void get_animail_which_number_of_paws_is_not_equal_to_age() {
        var animal1 = new Animal.AnimalBuilder().type(Animal.Type.DOG).age(4).build();
        var animal2 = new Animal.AnimalBuilder().type(Animal.Type.DOG).age(5).build();
        var animal3 = new Animal.AnimalBuilder().type(Animal.Type.FISH).age(4).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        var ofPawsIsNotEqualToAge = AnimalUtils.animalsWithfPawsIsNotEqualToAge(animals);

        Assertions.assertThat(ofPawsIsNotEqualToAge).isEqualTo(List.of(animal2, animal3));
    }

    @Test
    void get_animls_which_can_bite_and_height_upper_100() {
        var animal1 = new Animal.AnimalBuilder().bites(true).height(100).build();
        var animal2 = new Animal.AnimalBuilder().bites(false).height(100).build();
        var animal3 = new Animal.AnimalBuilder().bites(true).height(101).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        var canBiteAndHeightUpper100 = AnimalUtils.canBiteAndHeightUpper100(animals);

        Assertions.assertThat(canBiteAndHeightUpper100).isEqualTo(List.of(animal3));

    }

    @Test
    void count_animals_which_weight_is_more_than_height() {
        var animal1 = new Animal.AnimalBuilder().weight(7).height(5).build();
        var animal2 = new Animal.AnimalBuilder().weight(10).height(10).build();
        var animal3 = new Animal.AnimalBuilder().weight(19).height(15).build();

        var animals = List.of(animal1, animal2, animal3);
        var countAnimalsWhichWeightIsMoreThanHeight = AnimalUtils.countAnimalsWhichWeightIsMoreThanHeight(animals);

        Assertions.assertThat(countAnimalsWhichWeightIsMoreThanHeight).isEqualTo(2);
    }

    @Test
    void animals_with_more_than_two_words_in_name() {
        var animal1 = new Animal.AnimalBuilder().name("Rex").build();
        var animal2 = new Animal.AnimalBuilder().name("Rex Pivo").build();
        var animal3 = new Animal.AnimalBuilder().name("Diego Pivo Mama").build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        var animalsWithMoreThanTwoWordsInName = AnimalUtils.animalsWithMoreThanTwoWordsInName(animals);

        Assertions.assertThat(animalsWithMoreThanTwoWordsInName).isEqualTo(List.of(animal3));
    }

    @Test
    void has_dog_taller_than_K() {
        var animal1 = new Animal.AnimalBuilder().height(5).type(Animal.Type.DOG).build();
        var animal2 = new Animal.AnimalBuilder().height(10).type(Animal.Type.FISH).build();
        var animal3 = new Animal.AnimalBuilder().height(15).type(Animal.Type.SPIDER).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        var hasDogTallerThanK = AnimalUtils.hasDogTallerThanK(animals, 11);

        Assertions.assertThat(hasDogTallerThanK).isFalse();
    }

    @Test
    void get_animals_weight_which_age_is_in_k_to_l_by_type() {
        var animal1 = new Animal.AnimalBuilder().weight(7).type(Animal.Type.DOG).age(4).build();
        var animal2 = new Animal.AnimalBuilder().weight(10).type(Animal.Type.DOG).age(5).build();
        var animal3 = new Animal.AnimalBuilder().weight(19).type(Animal.Type.FISH).age(4).build();
        var animal4 = new Animal.AnimalBuilder().weight(15).type(Animal.Type.SPIDER).age(3).build();
        var animal5 = new Animal.AnimalBuilder().weight(20).type(Animal.Type.SPIDER).age(4).build();
        var animal6 = new Animal.AnimalBuilder().weight(15).type(Animal.Type.DOG).age(5).build();

        List<Animal> animals = List.of(animal1, animal2, animal3, animal4, animal5, animal6);
        var totalWeightByType = AnimalUtils.animalsWeightWhichAgeIsInKtoByType(animals, 1, 5);

        Assertions.assertThat(totalWeightByType)
            .isEqualTo(Map.of(Animal.Type.DOG, 7, Animal.Type.FISH, 19, Animal.Type.SPIDER, 35));
    }

    @Test
    void sorted_animals_by_type_sex_name() {
        var animal1 = new Animal.AnimalBuilder().name("Rex").type(Animal.Type.DOG).sex(Animal.Sex.M).build();
        var animal2 = new Animal.AnimalBuilder().name("Diego").type(Animal.Type.DOG).sex(Animal.Sex.M).build();
        var animal3 = new Animal.AnimalBuilder().name("Rex").type(Animal.Type.FISH).sex(Animal.Sex.F).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        var sortedAnimalsByTypeSexName = AnimalUtils.sortedAnimalsByTypeSexName(animals);

        Assertions.assertThat(sortedAnimalsByTypeSexName).isEqualTo(List.of(animal2, animal1, animal3));
    }

    @Test
    void if_spiders_bite_more_than_dogs_should_return_true() {
        var animal1 = new Animal.AnimalBuilder().type(Animal.Type.SPIDER).bites(true).build();
        var animal3 = new Animal.AnimalBuilder().type(Animal.Type.SPIDER).bites(true).build();
        var animal2 = new Animal.AnimalBuilder().type(Animal.Type.DOG).bites(true).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        var isSpidersBiteMoreThanDogs = AnimalUtils.isSpidersBiteMoreThanDogs(animals);

        Assertions.assertThat(isSpidersBiteMoreThanDogs).isTrue();
    }

    @Test
    void if_spiders_doesnt_bite_more_than_dogs_should_return_false() {
        var animal1 = new Animal.AnimalBuilder().type(Animal.Type.SPIDER).bites(true).build();
        var animal2 = new Animal.AnimalBuilder().type(Animal.Type.DOG).bites(true).build();

        List<Animal> animals = List.of(animal1, animal2);
        var isSpidersBiteMoreThanDogs = AnimalUtils.isSpidersBiteMoreThanDogs(animals);

        Assertions.assertThat(isSpidersBiteMoreThanDogs).isFalse();
    }

    @Test
    void the_heaviest_fish_in_lists() {
        var animal1 = new Animal.AnimalBuilder().type(Animal.Type.FISH).weight(10).build();
        var animal2 = new Animal.AnimalBuilder().type(Animal.Type.FISH).weight(20).build();
        var animal3 = new Animal.AnimalBuilder().type(Animal.Type.FISH).weight(30).build();
        var animal4 = new Animal.AnimalBuilder().type(Animal.Type.FISH).weight(40).build();
        var animal5 = new Animal.AnimalBuilder().type(Animal.Type.FISH).weight(50).build();

        List<Animal> animals = List.of(animal1, animal2, animal3);
        List<Animal> animals1 = List.of(animal4, animal5);
        List<List<Animal>> animalsLists = List.of(animals, animals1);
        var heaviestFishInLists = AnimalUtils.heaviestFishInLists(animalsLists);

        Assertions.assertThat(heaviestFishInLists).isEqualTo(animal5);
    }

    @Test
    void get_validation_errors() {
        var animal1 = new Animal.AnimalBuilder().weight(-5).age(1).height(-1).name("Rex").build();
        var animal3 = new Animal.AnimalBuilder().age(-7).height(5).weight(1).name("Pivo").build();

        List<Animal> animals = List.of(animal1, animal3);
        var validationErrors = AnimalUtils.validationErrors(animals);

        Assertions.assertThat(validationErrors)
            .isEqualTo(Map.of(
                "Rex",
                Set.of(
                    new ValidationError("height must be greater than zero"),
                    new ValidationError("weight must be greater than zero")
                ),
                "Pivo",
                Set.of(new ValidationError("age must be greater than zero"))
            ));
    }

    @Test
    void get_validation_error_messages() {
        var animal1 = new Animal.AnimalBuilder().weight(-5).age(1).height(-1).name("Rex").build();
        var animal3 = new Animal.AnimalBuilder().age(-7).height(5).weight(1).name("Pivo").build();

        List<Animal> animals = List.of(animal1, animal3);
        var validationErrors = AnimalUtils.getValidationErrorMessages(animals);

        Assertions.assertThat(validationErrors).isEqualTo(Map.of(
            "Rex", "height must be greater than zero, weight must be greater than zero",
            "Pivo", "age must be greater than zero"
        ));

    }
}

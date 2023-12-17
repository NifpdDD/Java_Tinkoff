package edu.hw10.task1;

import edu.hw10.task1.test_class.Dog;
import edu.hw10.task1.test_class.Person;
import edu.hw10.task1.test_class.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RandomObjectGeneratorTest {
    @Test void create_object_with_constructor() {
        RandomObjectGenerator generator = new RandomObjectGenerator();
        var object = generator.nextObject(Person.class);

        Assertions.assertThat(object.getAge()).isBetween(5, 90);
        Assertions.assertThat(object.getName()).isNotEmpty();
    }

    @Test void create_object_with_factory_method() {
        RandomObjectGenerator generator = new RandomObjectGenerator();
        var object = generator.nextObject(Student.class, "createStudent");

        Assertions.assertThat(object.getAge()).isBetween(0, 90);
        Assertions.assertThat(object.getName()).isEqualTo("John");
    }

    @Test void create_object_with_record() {
        RandomObjectGenerator generator = new RandomObjectGenerator();
        var object = generator.nextObject(Dog.class);

        Assertions.assertThat(object.age()).isBetween(5,20);
    }
}

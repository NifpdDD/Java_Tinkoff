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

    @Test
    void testIsNumericWithNumericTypeShouldReturnTrue() {
        RandomObjectGenerator generator = new RandomObjectGenerator();

        assertTrue(generator.isNumeric(int.class));
        assertTrue(generator.isNumeric(Integer.class));
        assertTrue(generator.isNumeric(double.class));
        assertTrue(generator.isNumeric(Double.class));
        assertTrue(generator.isNumeric(float.class));
        assertTrue(generator.isNumeric(Float.class));
        assertTrue(generator.isNumeric(long.class));
        assertTrue(generator.isNumeric(Long.class));
    }

    @Test
    void testIsNumericWithNonNumericTypeShouldReturnFalse() {
        RandomObjectGenerator generator = new RandomObjectGenerator();

        assertFalse(generator.isNumeric(String.class));
        assertFalse(generator.isNumeric(Object.class));
        assertFalse(generator.isNumeric(Boolean.class));
        assertFalse(generator.isNumeric(RandomObjectGenerator.class));
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

        Assertions.assertThat(object.age()).isBetween(5, 20);
    }
}

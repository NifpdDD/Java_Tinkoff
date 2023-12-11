package edu.hw7.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ReadWriteOptmCacheServiceTest {
    private ReadWriteOptmCacheService readWriteOptmCacheService;

    @BeforeEach
    void setUp() {
        readWriteOptmCacheService = new ReadWriteOptmCacheService();
    }

    @Test
    void testFindByRealAddress() {
        var person = new Person(4, "John Doe", "123 Main St", "555-1234");
        readWriteOptmCacheService.add(person);

        Person result = readWriteOptmCacheService.findByAddress("123 Main St");

        assertThat(result).isEqualTo(person);
    }

    @Test
    void testFindByRealPhone() {

        var person = new Person(4, "John Doe", "123 Main St", "555-1234");
        readWriteOptmCacheService.add(person);

        Person result = readWriteOptmCacheService.findByPhone("555-1234");

        assertThat(result).isEqualTo(person);
    }

    @Test
    void testAddRealPerson() {

        var person = new Person(4, "John Doe", "123 Main St", "555-1234");

        readWriteOptmCacheService.add(person);

        assertThat(readWriteOptmCacheService.findByName("John Doe")).isEqualTo(person);
        assertThat(readWriteOptmCacheService.findByAddress("123 Main St")).isEqualTo(person);
        assertThat(readWriteOptmCacheService.findByPhone("555-1234")).isEqualTo(person);
    }

    @Test
    void test_delete_person() {

        var person = new Person(4, "John Doe", "123 Main St", "555-1234");
        readWriteOptmCacheService.add(person);

        readWriteOptmCacheService.delete(4);

        assertThat(readWriteOptmCacheService.findByName("John Doe")).isNull();
        assertThat(readWriteOptmCacheService.findByAddress("123 Main St")).isNull();
        assertThat(readWriteOptmCacheService.findByPhone("555-1234")).isNull();
    }

}

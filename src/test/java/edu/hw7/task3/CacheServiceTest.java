package edu.hw7.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CacheServiceTest {
    private CacheService cacheService;

    @BeforeEach
    void setUp() {
        cacheService = new CacheService();
    }

    @Test
    void testFindByRealAddress() {
        var person = new Person(4, "John Doe", "123 Main St", "555-1234");
        cacheService.add(person);

        Person result = cacheService.findByAddress("123 Main St");

        assertThat(result).isEqualTo(person);
    }

    @Test
    void testFindByRealPhone() {

        var person = new Person(4, "John Doe", "123 Main St", "555-1234");
        cacheService.add(person);

        Person result = cacheService.findByPhone("555-1234");

        assertThat(result).isEqualTo(person);
    }

    @Test
    void testAddRealPerson() {

        var person = new Person(4, "John Doe", "123 Main St", "555-1234");

        cacheService.add(person);

        assertThat(cacheService.findByName("John Doe")).isEqualTo(person);
        assertThat(cacheService.findByAddress("123 Main St")).isEqualTo(person);
        assertThat(cacheService.findByPhone("555-1234")).isEqualTo(person);
    }

    @Test
    void test_delete_person() {

        var person = new Person(4, "John Doe", "123 Main St", "555-1234");
        cacheService.add(person);

        cacheService.delete(4);

        assertThat(cacheService.findByName("John Doe")).isNull();
        assertThat(cacheService.findByAddress("123 Main St")).isNull();
        assertThat(cacheService.findByPhone("555-1234")).isNull();
    }

}

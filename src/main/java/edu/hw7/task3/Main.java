package edu.hw7.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final int NUMBER_OF_THREADS = 12;
    public static final int INT = 100000;
    public static final Person PERSON = new Person(1, "Petr", "Perm", "25");
    public static final String TIME_NANOSECONDS = "Time: {} nanoseconds";

    private Main() {

    }

    private static final Logger LOGGER = LogManager.getLogger();


    public static void main(String[] args) {
        var cacheService = new CacheService();
        var start = System.nanoTime();
        var person = PERSON;
        cacheService.add(person);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread(() -> {
                for (int j = 0; j < INT; j++) {
                    cacheService.findByAddress("2");
                    cacheService.findByName("2");
                    cacheService.findByPhone("1");
                }
            });
        }
        var end = System.nanoTime();
        var duration = end - start;
        LOGGER.info(TIME_NANOSECONDS, duration);
        var cacheOptmServiceByAddress = new ReadWriteOptmCacheService();
        start = System.nanoTime();
        person = PERSON;
        cacheOptmServiceByAddress.add(person);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread(() -> {
                for (int j = 0; j < INT; j++) {
                    cacheOptmServiceByAddress.findByAddress("3");
                    cacheOptmServiceByAddress.findByName("4");
                    cacheOptmServiceByAddress.findByPhone("25");
                }
            });
        }
        end = System.nanoTime();
        duration = end - start;
        LOGGER.info(TIME_NANOSECONDS, duration);

    }
}

package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();

    public void printHelloWorld() {
        LOGGER.info("Привет, мир!");
    }
}

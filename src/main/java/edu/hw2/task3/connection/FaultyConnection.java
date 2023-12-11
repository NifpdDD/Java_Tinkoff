package edu.hw2.task3.connection;

import edu.hw2.task3.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();

    private final double faultyChance;

    public FaultyConnection(double faultyChance) {
        this.faultyChance = faultyChance;
    }

    public FaultyConnection() {
        this.faultyChance = 1;
    }


    @Override
    public void execute(String command) {
        if (Math.random() < faultyChance) {
            throw new ConnectionException("Connection error");
        }
        LOGGER.info("Successful execution of command {}", command);
    }

    @Override
    public void close() {
        LOGGER.info("Сonnection was closed");
    }
}

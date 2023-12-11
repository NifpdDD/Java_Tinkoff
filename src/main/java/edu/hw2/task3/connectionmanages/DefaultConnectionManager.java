package edu.hw2.task3.connectionmanages;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.FaultyConnection;
import edu.hw2.task3.connection.StableConnection;

public class DefaultConnectionManager implements ConnectionManager {
    private final double faultyConnectionChanche;

    public DefaultConnectionManager(double faultyConnectionChanche) {
        this.faultyConnectionChanche = faultyConnectionChanche;
    }

    public DefaultConnectionManager() {
        this.faultyConnectionChanche = 0;
    }

    @Override
    public Connection getConnection() {
        if (Math.random() < faultyConnectionChanche) {
            return new FaultyConnection(Math.random());
        }
        return new StableConnection();
    }
}

package edu.hw2.task3;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String connectionError) {
        super(connectionError);
    }

    public ConnectionException(String connectError, Throwable cause) {
        super(connectError, cause);
    }
}

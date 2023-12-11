package edu.hw2.task3;

import edu.hw2.task3.connectionmanages.ConnectionManager;

public class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public boolean tryExecute(String command) {
        for (int i = 0; i < maxAttempts; i++) {
            var connection = manager.getConnection();
            try {
                connection.execute(command);
                return true;
            } catch (ConnectionException e) {
                if (i == maxAttempts - 1) {
                    throw new ConnectionException("Connection error number of attempts exceeded", e);
                }
            }
        }
        return false;
    }
}

package edu.hw2;

import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.FaultyConnection;
import edu.hw2.task3.connectionmanages.DefaultConnectionManager;
import edu.hw2.task3.connectionmanages.FaultyConnectionManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task3Test {
    @Test
    void if_change_of_faulty_is_1_should_return_e() {
        var faulty = new FaultyConnection(1);

        Assertions.assertThatThrownBy(() -> faulty.execute("Абоба")).isInstanceOf(ConnectionException.class);
    }

    @Test
    void if_faulty_connectiom_manager_should_return_faulty_connection() {
        var fcnm = new FaultyConnectionManager();

        var con = fcnm.getConnection();

        Assertions.assertThat(con).isInstanceOf(FaultyConnection.class);

    }

    @Test
    void if_default_connectiom_manager_1_should_return_faulty_connection() {
        var dcm = new DefaultConnectionManager(1);

        var con = dcm.getConnection();

        Assertions.assertThat(con).isInstanceOf(FaultyConnection.class);

    }

    @Test
    void if_default_connectiom_manager_should_return_connection() {
        var dcm = new DefaultConnectionManager(1);

        var con = dcm.getConnection();

        Assertions.assertThat(con).isInstanceOf(Connection.class);

    }

    @Test
    void if_faulty_chanche_1_should_return_e() {
        var fcm = new FaultyConnectionManager();
        var pce = new PopularCommandExecutor(fcm, 5);

        Assertions.assertThatThrownBy(() -> pce.updatePackages()).isInstanceOf(ConnectionException.class);
    }

    @Test
    void if_faulty_chanche_0_should_return_ok() {
        var dcm = new DefaultConnectionManager();
        var pce = new PopularCommandExecutor(dcm, 5);

        var flag = pce.tryExecute("пиво");

        Assertions.assertThat(flag).isTrue();

    }
}


package edu.hw6.port_scanner;

import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class PortScanner {
    private static final Map<Integer, String> PORTS = Map.of(
        135, "EPMAP",
        137, "Служба имен NetBIOS",
        143, "IMAP"
    );
    private static final int MIN_PORT = 0;
    private static final int MAX_PORT = 49151;

    private PortScanner() {
    }

    public static List<ScanResult> scanPorts() {
        List<ScanResult> results = new ArrayList<>();
        for (int port = MIN_PORT; port <= MAX_PORT; ++port) {
            scanTcpPort(port, results);
            scanUdpPort(port, results);
        }
        return results;
    }

    private static void scanTcpPort(int port, List<ScanResult> results) {
        Status status = isTcpPortClosed(port);
        scanPort(Protocol.TCP, port, status, results);
    }

    private static void scanUdpPort(int port, List<ScanResult> results) {
        Status status = isUdpPortClosed(port);
        scanPort(Protocol.UDP, port, status, results);
    }

    private static Status isTcpPortClosed(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            return Status.OPEN;
        } catch (Exception e) {
            return Status.CLOSED;
        }
    }

    private static Status isUdpPortClosed(int port) {
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            return Status.OPEN;
        } catch (Exception e) {
            return Status.CLOSED;
        }
    }

    private static void scanPort(Protocol protocol, int port, Status status, List<ScanResult> results) {
        String service = PORTS.getOrDefault(port, "");

        if (!service.isEmpty() && status == Status.OPEN) {
            results.add(new ScanResult(protocol.toString(), port, service));
        }
    }

    private enum Protocol {
        TCP, UDP
    }

    private enum Status {
        OPEN, CLOSED
    }

    public record ScanResult(String protocol, int port, String service) {

    }
}

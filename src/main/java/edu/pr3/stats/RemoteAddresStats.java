package edu.pr3.stats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

public class RemoteAddresStats implements Stats {

    public static final String TITLE = "Удаленные адреса";
    public static final List<String> HEADERS = List.of("Адрес", "Количество");
    @Getter private static Map<String, Long> freqOfAddress = new HashMap<>();

    public static void addAdrress(String resources) {
        RemoteAddresStats.freqOfAddress.put(resources, RemoteAddresStats.freqOfAddress.getOrDefault(resources, 0L) + 1);
    }

    public List<List<String>> getStats(int k) {
        return RemoteAddresStats.freqOfAddress.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .limit(k)
            .map(entry -> Arrays.asList(entry.getKey(), entry.getValue().toString()))
            .toList();
    }

    @Override
    public List<String> getHeader() {
        return HEADERS;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}

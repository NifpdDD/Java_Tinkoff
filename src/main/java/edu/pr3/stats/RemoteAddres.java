package edu.pr3.stats;

import lombok.Getter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteAddres implements Stats{

    public static final String TITLE = "Удаленные адреса";
    public static final List<String> HEADERS = List.of("Адрес", "Количество");
    @Getter private static Map<String, Long> freqOfResources = new HashMap<>();

    public static void addAdrress(String resources) {
        RemoteAddres.freqOfResources.put(resources, RemoteAddres.freqOfResources.getOrDefault(resources, 0L) + 1);
    }
    public List<List<String>> getStats(int k) {
        return RemoteAddres.freqOfResources.entrySet().stream()
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

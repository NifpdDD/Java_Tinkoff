package edu.pr3.stats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

public class ResourcesStats implements Stats {
    public static final String TITLE = "Запрашиваемые ресурсы";
    public static final List<String> HEADERS = List.of("Ресурс", "Количество");
    @Getter private Map<String, Long> freqOfResources = new HashMap<>();

    public ResourcesStats() {

    }

    public void addResource(String resource) {
        freqOfResources.put(resource, freqOfResources.getOrDefault(resource, 0L) + 1);
    }

    public List<List<String>> getStats(int k) {
        return freqOfResources.entrySet().stream()
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

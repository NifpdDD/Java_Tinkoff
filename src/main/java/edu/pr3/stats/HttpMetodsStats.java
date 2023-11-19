package edu.pr3.stats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

public class HttpMetodsStats implements Stats {

    public static final String TITLE = "HTTP-методы";
    public static final List<String> HEADERS = List.of("Метод", "Количество");
    @Getter private static Map<String, Long> freqOfMethods = new HashMap<>();

    public static void addMethod(String resources) {
        HttpMetodsStats.freqOfMethods.put(resources, HttpMetodsStats.freqOfMethods.getOrDefault(resources, 0L) + 1);
    }

    public List<List<String>> getStats(int k) {
        return HttpMetodsStats.freqOfMethods.entrySet().stream()
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

package edu.pr3.stats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter public class HttpMetodsStats implements Stats {

    private static final String TITLE = "HTTP-методы";
    private static final List<String> HEADERS = List.of("Метод", "Количество");
    private Map<String, Long> freqOfMethods = new HashMap<>();


    public void addMethod(String resources) {
        freqOfMethods.put(resources, freqOfMethods.getOrDefault(resources, 0L) + 1);
    }

    public List<List<String>> getStats(int k) {
        return freqOfMethods.entrySet().stream()
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

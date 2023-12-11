package edu.pr3.stats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.httpclient.HttpStatus;

public class CodeAnsStats implements Stats {
    private static final String TITLE = "Коды ответа";
    private static final List<String> HEADERS = List.of("Код", "Описание", "Количество");

    private final Map<Integer, Long> freqCodeAns = new HashMap<>();

    public void addCode(Integer code) {
        freqCodeAns.put(code, freqCodeAns.getOrDefault(code, 0L) + 1);
    }

    public List<List<String>> getStats(int k) {
        return freqCodeAns.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .limit(k)
            .map(entry -> Arrays.asList(
                entry.getKey().toString(),
                HttpStatus.getStatusText(entry.getKey()),
                entry.getValue().toString()
            ))
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

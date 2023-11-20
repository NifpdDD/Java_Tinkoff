package edu.pr3.stats;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.httpclient.HttpStatus;

public class CodeAnsStats implements Stats {
    public static final String TITLE = "Коды ответа";
    public static final List<String> HEADERS = List.of("Код", "Описание", "Количество");

    private Map<Integer, Long> FFREQ_CODE_ANS = new HashMap<>();

    public CodeAnsStats() {
    }

    public void addCode(Integer code) {
        FFREQ_CODE_ANS.put(code, FFREQ_CODE_ANS.getOrDefault(code, 0L) + 1);
    }

    public List<List<String>> getStats(int k) {
        return FFREQ_CODE_ANS.entrySet().stream()
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

package edu.pr3.stats;

import edu.pr3.InputAnalyzer;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter public class GeneralStats implements Stats {
    private static final String TITLE = "Общая информация";
    private static final List<String> HEADERS = List.of("Метрика", "Значение");

    private final List<String> files = new ArrayList<>();
    private long numberOfLogs = 0;
    private long sumOfResponseSize = 0;

    public void addFile(String file) {
        files.add(file);
    }

    public List<List<String>> getStats(int k) {
        var stats = new ArrayList<List<String>>();
        for (int i = 1; i < k + 1 && i <= files.size(); i++) {
            stats.add(List.of("Файл " + i, files.get(i - 1)));
        }
        stats.add(List.of("Начальная дата", InputAnalyzer.getFromDate()));
        stats.add(List.of("Конечная дата", InputAnalyzer.getToDate()));
        stats.add(List.of("Количество запросов ", String.valueOf(numberOfLogs)));
        stats.add(List.of("Средний размер ответа", sumOfResponseSize / numberOfLogs + "b"));
        return stats;
    }

    @Override
    public List<String> getHeader() {
        return HEADERS;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    public void setNumberOfLogs(long numberOfLogs) {
        this.numberOfLogs = numberOfLogs;
    }

    public void setSumOfResponseSize(long sumOfResponseSize) {
        this.sumOfResponseSize = sumOfResponseSize;
    }
}

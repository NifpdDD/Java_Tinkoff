package edu.pr3.stats;

import edu.pr3.InputAnalyzer;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class GeneralStats implements Stats {
    public static final String TITLE = "Общая информация";
    public static final List<String> HEADERS = List.of("Метрика", "Значение");

    @Getter private static List<String> files = new ArrayList<>();
    @Getter private static long numberOfLogs = 0;
    @Getter private static long sumOfResponseSize = 0;

    public static void addFile(String file) {
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

    public static void setFiles(List<String> files) {
        GeneralStats.files = files;
    }

    public static void setNumberOfLogs(long numberOfLogs) {
        GeneralStats.numberOfLogs = numberOfLogs;
    }

    public static void setSumOfResponseSize(long sumOfResponseSize) {
        GeneralStats.sumOfResponseSize = sumOfResponseSize;
    }
}

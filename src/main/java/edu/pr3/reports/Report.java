package edu.pr3.reports;

import edu.pr3.stats.Stats;
import java.util.ArrayList;
import java.util.List;

public abstract class Report {
    protected static final int MAX_NUMBER_OF_FILES_IN_TABLE = 10;

    public static List<String> generateReport(String format, List<Stats> summaryStats) {
        Report typeReport = getTypeOfReport(format);
        List<String> report = new ArrayList<>();
        for (var stat : summaryStats) {
            report.add("## " + stat.getTitle());
            writeHeadLine(typeReport.getHeadLineAndName(stat), report);
            writeBody(typeReport.getBody(stat), report);
        }
        return report;
    }

    protected static StringBuilder getHead(Stats type) {
        var head = new StringBuilder();
        for (var header : type.getHeader()) {
            head.append("|").append(header);
        }
        return head;
    }

    private static void writeBody(List<String> body, List<String> report) {
        for (var line : body) {
            report.add(String.valueOf(line));
        }
    }

    private static void writeHeadLine(List<StringBuilder> headLine, List<String> report) {
        for (var line : headLine) {
            report.add(String.valueOf(line));
        }
    }

    private static Report getTypeOfReport(String format) {
        IllegalArgumentException exception = new IllegalArgumentException("Unknown format: " + format);
        switch (format) {
            case "markdown" -> {
                return new MarkDownReport();
            }
            case "adoc" -> {
                return new AdocReport();
            }
            default -> throw exception;
        }
    }

    protected static StringBuilder getBodyLine(List<String> statsRow) {
        var body = new StringBuilder();
        for (String s : statsRow) {
            body.append("|").append(s);
        }
        return body;
    }

    protected abstract List<StringBuilder> getHeadLineAndName(Stats type);

    protected abstract List<String> getBody(Stats stats);

}

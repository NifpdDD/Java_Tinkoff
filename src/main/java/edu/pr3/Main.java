package edu.pr3;

import edu.pr3.reports.Report;
import edu.pr3.stats.Stats;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private Main() {

    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void main(String[] args) throws IOException, URISyntaxException {
        InputAnalyzer.parseArgs(args);

        String pathOrUrl = InputAnalyzer.getLogPath();
        try {
            var info = PathReader.readPathOrUrl(pathOrUrl);
            var report = Report.generateReport(InputAnalyzer.getOutputFormat(), info.getAllStatstics());
            for (String line : report) {
                System.out.println(line);
            }
        } catch (RuntimeException e) {
            throw new ArithmeticException("Error: Логи не найдены или какие-то файлы повреждены");
        }
    }

}


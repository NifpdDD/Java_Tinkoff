package edu.pr3;

import edu.pr3.reports.Report;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    private Main() {

    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void main(String[] args) throws IOException, URISyntaxException {
        InputAnalyzer.parseArgs(args);

        String pathOrUrl = InputAnalyzer.getLogPath();
        try {
            var info = PathReader.readPathOrUrl(pathOrUrl);
            var report = Report.generateReport(InputAnalyzer.getOutputFormat(), info);
            for (String line : report) {
                System.out.println(line);
            }
        } catch (RuntimeException e) {
            throw new ArithmeticException("Error: Логи не найдены или какие-то файлы повреждены");
        }
    }

}


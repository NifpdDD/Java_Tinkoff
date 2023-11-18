package edu.pr3;

import edu.pr3.stats.CodeAnsStats;
import edu.pr3.stats.GeneralStats;
import edu.pr3.stats.ResourcesStats;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import static edu.pr3.Patterns.PATTENRN_RESOURCES;

public class LogAnalyse {
    private LogAnalyse() {

    }

    public static void analyseDoc(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            var log = LogParse.parse(line);
            if (log != null
                && log.dateTimeLocal().toLocalDateTime().isAfter(InputAnalyzer.getFromDateAsOffsetDateTime())
                && log.dateTimeLocal().toLocalDateTime().isBefore(InputAnalyzer.getToDateAsOffsetDateTime())) {
                Matcher matcher = PATTENRN_RESOURCES.matcher(log.request());
                if (matcher.matches()) {
                    ResourcesStats.addResources(matcher.group(1));
                }
                GeneralStats.setNumberOfLogs(GeneralStats.getNumberOfLogs() + 1);
                GeneralStats.setSumOfResponseSize(
                    GeneralStats.getSumOfResponseSize() + log.bodyBytesSent());
                CodeAnsStats.addResources(log.status());
            }
        }
    }
}

package edu.pr3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;

public class DocAnalyser {
    private DocAnalyser() {

    }

    public static void analyseDoc(
        BufferedReader reader,
        StatsCollector statsCollector
        ) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            var log = LogParse.parse(line);
            collectionOfStatistics(statsCollector, log);
        }
    }

    private static void collectionOfStatistics(
        StatsCollector statsCollector,
        Log log
    ) {
        if (log != null
            && log.dateTimeLocal().toLocalDateTime().isAfter(InputAnalyzer.getFromDateAsOffsetDateTime())
            && log.dateTimeLocal().toLocalDateTime().isBefore(InputAnalyzer.getToDateAsOffsetDateTime())) {
            Matcher matcher = Patterns.RESOURCES.getPattern().matcher(log.request());
            if (matcher.matches()) {
                getLineStats(
                    matcher,
                    log,
                    statsCollector
                );
            }
        }
    }

    private static void
    getLineStats(
        Matcher matcher,
        Log log,
        StatsCollector statsCollector
    ) {
        statsCollector.getHttpMetodsStats().addMethod(matcher.group(1));
        statsCollector.getResourcesStats().addResource(matcher.group(2));
        statsCollector.getRemoteAddresStats().addAddress(log.remoteAddr());
        statsCollector.getGeneralStats().setNumberOfLogs(statsCollector.getGeneralStats().getNumberOfLogs() + 1);
        statsCollector.getGeneralStats().setSumOfResponseSize(
            statsCollector.getGeneralStats().getSumOfResponseSize() + log.bodyBytesSent());
        statsCollector.getCodeAnsStats().addCode(log.status());
    }
}

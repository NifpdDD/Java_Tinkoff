package edu.pr3;

import edu.pr3.stats.CodeAnsStats;
import edu.pr3.stats.GeneralStats;
import edu.pr3.stats.HttpMetodsStats;
import edu.pr3.stats.RemoteAddresStats;
import edu.pr3.stats.ResourcesStats;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;

public class LogAnalyse {
    private LogAnalyse() {

    }

    public static void analyseDoc(
        BufferedReader reader,
        ResourcesStats resourcesStats,
        RemoteAddresStats remoteAddresStats,
        HttpMetodsStats httpMetodsStats,
        GeneralStats generalStats,
        CodeAnsStats codeAnsStats
        ) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            var log = LogParse.parse(line);
            if (log != null
                && log.dateTimeLocal().toLocalDateTime().isAfter(InputAnalyzer.getFromDateAsOffsetDateTime())
                && log.dateTimeLocal().toLocalDateTime().isBefore(InputAnalyzer.getToDateAsOffsetDateTime())) {
                Matcher matcher = Patterns.RESOURCES.getPattern().matcher(log.request());
                if (matcher.matches()) {
                    getLineStats(
                        matcher,
                        log,
                        httpMetodsStats,
                        resourcesStats,
                        remoteAddresStats,
                        codeAnsStats,
                        generalStats
                    );
                }
            }
        }
    }

    private static void getLineStats(
        Matcher matcher,
        Log log,
        HttpMetodsStats httpMetodsStats,
        ResourcesStats resourcesStats,
        RemoteAddresStats remoteAddresStats,
        CodeAnsStats codeAnsStats,
        GeneralStats generalStats
    ) {
        httpMetodsStats.addMethod(matcher.group(1));
        resourcesStats.addResource(matcher.group(2));
        remoteAddresStats.addAddress(log.remoteAddr());
        generalStats.setNumberOfLogs(generalStats.getNumberOfLogs() + 1);
        generalStats.setSumOfResponseSize(
            generalStats.getSumOfResponseSize() + log.bodyBytesSent());
        codeAnsStats.addCode(log.status());
    }
}

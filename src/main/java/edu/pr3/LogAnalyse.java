package edu.pr3;

import edu.pr3.stats.CodeAnsStats;
import edu.pr3.stats.GeneralStats;
import edu.pr3.stats.HttpMetodsStats;
import edu.pr3.stats.RemoteAddresStats;
import edu.pr3.stats.ResourcesStats;
import edu.pr3.stats.Stats;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;

public class LogAnalyse {
    private LogAnalyse() {

    }

    public static List<Stats> analyseDoc(BufferedReader reader) throws IOException {
        String line;
        var generalStats = new GeneralStats();
        var httpMetodsStats = new HttpMetodsStats();
        var resourcesStats = new ResourcesStats();
        var remoteAddresStats = new RemoteAddresStats();
        var codeAnsStats = new CodeAnsStats();
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
        return List.of(generalStats, httpMetodsStats, resourcesStats, remoteAddresStats, codeAnsStats);
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

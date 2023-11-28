package edu.pr3;

import edu.pr3.stats.CodeAnsStats;
import edu.pr3.stats.GeneralStats;
import edu.pr3.stats.HttpMetodsStats;
import edu.pr3.stats.RemoteAddresStats;
import edu.pr3.stats.ResourcesStats;
import edu.pr3.stats.Stats;
import java.util.List;
import java.util.regex.Matcher;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter public class StatsManager {
    private GeneralStats generalStats = new GeneralStats();
    private CodeAnsStats codeAnsStats = new CodeAnsStats();
    private RemoteAddresStats remoteAddresStats = new RemoteAddresStats();
    private ResourcesStats resourcesStats = new ResourcesStats();
    private HttpMetodsStats httpMetodsStats = new HttpMetodsStats();

    void collectionOfStatistics(
        Log log
    ) {
        if (log != null
            && log.dateTimeLocal().toLocalDateTime().isAfter(InputAnalyzer.getFromDateAsOffsetDateTime())
            && log.dateTimeLocal().toLocalDateTime().isBefore(InputAnalyzer.getToDateAsOffsetDateTime())) {
            Matcher matcher = Patterns.RESOURCES.getPattern().matcher(log.request());
            if (matcher.matches()) {
                getHttpMetodsStats().addMethod(matcher.group(1));
                getResourcesStats().addResource(matcher.group(2));
                getRemoteAddresStats().addAddress(log.remoteAddr());
                getGeneralStats().setNumberOfLogs(getGeneralStats().getNumberOfLogs() + 1);
                getGeneralStats().setSumOfResponseSize(
                    getGeneralStats().getSumOfResponseSize() + log.bodyBytesSent());
                getCodeAnsStats().addCode(log.status());
            }
        }
    }

    public  List<Stats> getAllStatstics() {
        return List.of(
            generalStats,
            resourcesStats,
            codeAnsStats,
            remoteAddresStats,
            httpMetodsStats
        );
    }
}

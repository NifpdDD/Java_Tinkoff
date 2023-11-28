package edu.pr3;

import edu.pr3.stats.CodeAnsStats;
import edu.pr3.stats.GeneralStats;
import edu.pr3.stats.HttpMetodsStats;
import edu.pr3.stats.RemoteAddresStats;
import edu.pr3.stats.ResourcesStats;
import edu.pr3.stats.Stats;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter public class StatsCollector {
    private GeneralStats generalStats = new GeneralStats();
    private CodeAnsStats codeAnsStats = new CodeAnsStats();
    private RemoteAddresStats remoteAddresStats = new RemoteAddresStats();
    private ResourcesStats resourcesStats = new ResourcesStats();
    private HttpMetodsStats httpMetodsStats = new HttpMetodsStats();

    public List<Stats> getAllStatstics() {
        return List.of(
            generalStats,
            resourcesStats,
            codeAnsStats,
            remoteAddresStats,
            httpMetodsStats
        );
    }
}

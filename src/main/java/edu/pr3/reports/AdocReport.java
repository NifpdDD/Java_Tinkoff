package edu.pr3.reports;

import edu.pr3.stats.Stats;
import java.util.ArrayList;
import java.util.List;

public class AdocReport extends Report {

    public static final String LINE = "|===";

    @Override
    protected List<StringBuilder> getHeadLineAndName(Stats type) {
        var head = getHead(type);
        return List.of(new StringBuilder(LINE), head, new StringBuilder());
    }

    @Override
    protected List<String> getBody(Stats stats) {
        var report = new ArrayList<String>();
        for (var statsRow : stats.getStats(Report.MAX_NUMBER_OF_FILES_IN_TABLE)) {
            var body = Report.getBodyLine(statsRow);
            report.add(String.valueOf(body));
        }
        report.addAll(List.of(LINE, ""));
        return report;
    }
}

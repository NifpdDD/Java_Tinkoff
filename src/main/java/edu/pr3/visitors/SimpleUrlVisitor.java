package edu.pr3.visitors;

import edu.pr3.InputAnalyzer;
import edu.pr3.Patterns;
import edu.pr3.StatsManager;
import edu.pr3.stats.Stats;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import static edu.pr3.DocAnalyser.analyseDoc;

public class SimpleUrlVisitor {
    private SimpleUrlVisitor() {

    }

    public static List<Stats> analyseURL(String pathOrUrl, InputAnalyzer inputAnalyzer)
        throws IOException, URISyntaxException {
        Matcher matcher;
        StatsManager statsManager = new StatsManager(inputAnalyzer);
        matcher = Patterns.URL.getPattern().matcher(pathOrUrl);
        if (matcher.matches()) {
            statsManager.getGeneralStats().addFile(matcher.group(1));
            var uri = new URI(pathOrUrl);
            var url = uri.toURL();
            try (var reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                analyseDoc(reader, statsManager, inputAnalyzer);
            }
        }
        return statsManager.getAllStatstics();
    }

}

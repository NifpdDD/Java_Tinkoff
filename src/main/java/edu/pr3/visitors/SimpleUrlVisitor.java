package edu.pr3.visitors;

import edu.pr3.Patterns;
import edu.pr3.StatsCollector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import static edu.pr3.DocAnalyser.analyseDoc;

public class SimpleUrlVisitor {
    private SimpleUrlVisitor() {

    }

    public static StatsCollector analyseURL(String pathOrUrl) throws IOException, URISyntaxException {
        Matcher matcher;
        StatsCollector statsCollector = new StatsCollector();
        matcher = Patterns.URL.getPattern().matcher(pathOrUrl);
        if (matcher.matches()) {
            statsCollector.getGeneralStats().addFile(matcher.group(1));
            var uri = new URI(pathOrUrl);
            var url = uri.toURL();
            try (var reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                analyseDoc(reader, statsCollector);
            }
        }
        return statsCollector;
    }

}

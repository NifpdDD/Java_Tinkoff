package edu.pr3.visitors;

import edu.pr3.stats.GeneralStats;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import static edu.pr3.LogAnalyse.analyseDoc;
import static edu.pr3.Patterns.PATTERN_URL;

public class SimpleUrlVisitor {
    private SimpleUrlVisitor() {

    }

    public static void analyseURL(String pathOrUrl) throws IOException, URISyntaxException {
        Matcher matcher;
        matcher = PATTERN_URL.matcher(pathOrUrl);
        if (matcher.matches()) {
            GeneralStats.addFile(matcher.group(1));
            var uri = new URI(pathOrUrl);
            var url = uri.toURL();
            try (var reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                analyseDoc(reader);
            }
        }
    }

}

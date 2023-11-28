package edu.pr3;

import edu.pr3.stats.Stats;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import static edu.pr3.visitors.SimpleFileByPatternVisitor.analyseFileFromDir;
import static edu.pr3.visitors.SimpleUrlVisitor.analyseURL;

public class PathReader {

    private PathReader() {

    }

    static List<Stats> readPathOrUrl(String pathOrUrl) throws IOException, URISyntaxException {
        if (pathOrUrl.startsWith("http")) {
            return analyseURL(pathOrUrl);
        }
        var dir = getStartDir(pathOrUrl);
        return analyseFileFromDir(dir, pathOrUrl);
    }

    private static String getStartDir(String path) {
        int firstAsteriskIndex = path.indexOf("*");
        if (firstAsteriskIndex == -1) {
            return path;
        }
        int lastSlashIndex = path.lastIndexOf("/", firstAsteriskIndex);
        return path.substring(0, lastSlashIndex);
    }

}

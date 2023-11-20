package edu.pr3;

import java.io.IOException;
import java.net.URISyntaxException;
import static edu.pr3.visitors.SimpleFileByPatternVisitor.analyseFileFromDir;
import static edu.pr3.visitors.SimpleUrlVisitor.analyseURL;

public class LogReader {

    private LogReader() {

    }

    static void readPathOrUrl(String pathOrUrl) throws IOException, URISyntaxException {
        if (pathOrUrl.startsWith("http")) {
            analyseURL(pathOrUrl);
            return;
        }
            var dir = getStartDir(pathOrUrl);
            analyseFileFromDir(dir, pathOrUrl);
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

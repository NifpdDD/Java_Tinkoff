package edu.pr3.visitors;

import edu.pr3.stats.GeneralStats;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import static edu.pr3.AnalyseFile.analyseDoc;
import static edu.pr3.Patterns.PATTERN_FILE_NAME;

public class SimpleFileByPatternVisitor extends SimpleFileVisitor<Path> {
    private final PathMatcher pathMatcher;

    public SimpleFileByPatternVisitor(PathMatcher pathMatcher) {
        this.pathMatcher = pathMatcher;
    }

    public static void analyseFileFromDir(String dir, String pathOrUrl) throws IOException {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + pathOrUrl);
        Files.walkFileTree(Path.of(dir), new SimpleFileByPatternVisitor(pathMatcher));
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (pathMatcher.matches(file)) {
            Matcher matcher = PATTERN_FILE_NAME.matcher(file.toString());
            if (matcher.matches()) {
                GeneralStats.addFile(matcher.group(1));
            }
            try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_16LE)) {
                analyseDoc(reader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return FileVisitResult.CONTINUE;
    }

}

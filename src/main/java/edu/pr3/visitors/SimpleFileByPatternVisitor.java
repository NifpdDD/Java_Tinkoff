package edu.pr3.visitors;

import edu.pr3.Patterns;
import edu.pr3.StatsManager;
import edu.pr3.stats.Stats;
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
import java.util.List;
import java.util.regex.Matcher;
import static edu.pr3.DocAnalyser.analyseDoc;

public class SimpleFileByPatternVisitor extends SimpleFileVisitor<Path> {
    private final PathMatcher pathMatcher;
    private final StatsManager statsManager;

    public SimpleFileByPatternVisitor(PathMatcher pathMatcher) {
        this.pathMatcher = pathMatcher;
        this.statsManager = new StatsManager();

    }

    public static List<Stats> analyseFileFromDir(String dir, String pathOrUrl) throws IOException {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + pathOrUrl);
        var simpleFileByPatternVisitor = new SimpleFileByPatternVisitor(pathMatcher);
        Files.walkFileTree(Path.of(dir), simpleFileByPatternVisitor);
        return simpleFileByPatternVisitor.statsManager.getAllStatstics();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (pathMatcher.matches(file)) {
            Matcher matcher = Patterns.FILE_NAME.getPattern().matcher(file.toString());
            if (matcher.matches()) {
                statsManager.getGeneralStats().addFile(matcher.group(1));
                try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_16LE)) {
                    analyseDoc(reader, statsManager);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return FileVisitResult.CONTINUE;
    }

}

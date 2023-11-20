package edu.pr3.visitors;

import edu.pr3.Patterns;
import edu.pr3.stats.CodeAnsStats;
import edu.pr3.stats.GeneralStats;
import edu.pr3.stats.HttpMetodsStats;
import edu.pr3.stats.RemoteAddresStats;
import edu.pr3.stats.ResourcesStats;
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
import static edu.pr3.LogAnalyse.analyseDoc;

public class SimpleFileByPatternVisitor extends SimpleFileVisitor<Path> {
    private final PathMatcher pathMatcher;
    private final CodeAnsStats codeAnsStats;
    private final GeneralStats generalStats;
    private final ResourcesStats resourcesStats;
    private final RemoteAddresStats remoteAddresStats;
    private final HttpMetodsStats httpMetodsStats;

    public SimpleFileByPatternVisitor(PathMatcher pathMatcher) {
        this.pathMatcher = pathMatcher;
        this.codeAnsStats = new CodeAnsStats();
        this.generalStats = new GeneralStats();
        this.resourcesStats = new ResourcesStats();
        this.remoteAddresStats = new RemoteAddresStats();
        this.httpMetodsStats = new HttpMetodsStats();
    }

    public static List<Stats> analyseFileFromDir(String dir, String pathOrUrl) throws IOException {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + pathOrUrl);
        var simpleFileByPatternVisitor = new SimpleFileByPatternVisitor(pathMatcher);
        Files.walkFileTree(Path.of(dir), simpleFileByPatternVisitor);
        return List.of(
            simpleFileByPatternVisitor.generalStats,
            simpleFileByPatternVisitor.resourcesStats,
            simpleFileByPatternVisitor.codeAnsStats,
            simpleFileByPatternVisitor.remoteAddresStats,
            simpleFileByPatternVisitor.httpMetodsStats
        );
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (pathMatcher.matches(file)) {
            Matcher matcher = Patterns.FILE_NAME.getPattern().matcher(file.toString());
            if (matcher.matches()) {
                generalStats.addFile(matcher.group(1));
                try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_16LE)) {
                    analyseDoc(reader, resourcesStats, remoteAddresStats, httpMetodsStats, generalStats, codeAnsStats);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return FileVisitResult.CONTINUE;
    }

}

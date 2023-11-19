package edu.hw6.task3;

import java.nio.file.FileSystems;

public interface RegexContainsFilter extends AbstractFilter {
    static AbstractFilter regexContains(String pattern) {
        var matcher = FileSystems.getDefault().getPathMatcher("regex:" + pattern);
        return path -> matcher.matches(path.getFileName());
    }
}

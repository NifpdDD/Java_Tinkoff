package edu.pr3;

import java.util.regex.Pattern;

public enum Patterns {
    FILE_NAME(".*(\\\\.*\\\\.*)"),
    RESOURCES(".*(/.*)\\s.*"),
    URL(".*/(.*)");

    private final Pattern pattern;

    Patterns(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public Pattern getPattern() {
        return pattern;
    }
}

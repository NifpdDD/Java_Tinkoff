package edu.pr3;

import java.util.regex.Pattern;
import lombok.Getter;

@Getter public enum Patterns {
    FILE_NAME(".*(/.*/.*)"),
    RESOURCES("(\\w+).*(/.*)\\s.*"),
    URL(".*/(.*)");

    private final Pattern pattern;

    Patterns(String regex) {
        this.pattern = Pattern.compile(regex);
    }

}

package edu.pr3;

import java.util.regex.Pattern;

public class Patterns {
    private Patterns() {

    }

    public static final Pattern PATTERN_FILE_NAME = Pattern.compile(".*(\\\\.*\\\\.*)");
    public static final Pattern PATTENRN_RESOURCES = Pattern.compile(".*(/.*)\\s.*");
    public static final Pattern PATTERN_URL = Pattern.compile(".*/(.*)");

}

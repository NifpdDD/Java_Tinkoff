package edu.hw6.task3;

public interface ExtensionMatchesFilter extends AbstractFilter {
    static AbstractFilter extensionMatches(String extension) {
        return path -> path.getFileName().toString().matches(".*." + extension + "$");
    }

}

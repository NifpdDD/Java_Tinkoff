package edu.hw6.task3;

import java.nio.file.Files;

public interface LagerThanFilter extends AbstractFilter {
    static AbstractFilter lagerThan(int value) {
        return file -> Files.size(file) > value;
    }
}

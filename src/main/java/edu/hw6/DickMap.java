package edu.hw6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class DickMap implements Map<String, String> {
    private final Path filePath;
    private final Map<String, String> diskMap = new HashMap<>();

    public DickMap(String path) throws IOException {
        this.filePath = Path.of(path);
        createFileIfNotExists();
        loadFromDisk();
    }

    private void createFileIfNotExists() throws IOException {
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    private void loadFromDisk() throws IOException {
        try (var lines = Files.lines(filePath)) {
            lines.map(line -> line.split(":"))
                .filter(parts -> parts.length == 2)
                .forEach(parts -> diskMap.put(parts[0], parts[1]));
        }
    }

    private void saveToDisk() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(filePath)))) {
            for (var entry : diskMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        }
    }

    @Override
    public int size() {
        try {
            loadFromDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return diskMap.size();
    }

    @Override
    public boolean isEmpty() {
        try {
            loadFromDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return diskMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            loadFromDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return diskMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        try {
            loadFromDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return diskMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        try {
            loadFromDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return diskMap.get(key);
    }

    @Override
    public String put(String key, String value) {
        var putValue = diskMap.put(key, value);
        try {
            saveToDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return putValue;
    }

    @Override
    public String remove(Object key) {
        var removeValue = diskMap.remove(key);
        try {
            saveToDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return removeValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        m.forEach(this::put);
        try {
            saveToDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        diskMap.clear();
        try {
            saveToDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        try {
            loadFromDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return diskMap.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        try {
            loadFromDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return diskMap.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        try {
            loadFromDisk();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return diskMap.entrySet();
    }
}

package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class DickMapTest {
    @Test
    void if_add_should_save_changes_in_file(@TempDir Path tempDir) throws IOException {
        String path = tempDir.resolve("disk.txt").toString();
        var map = new DickMap(path);

        map.put("1", "2");

        Assertions.assertThat(Files.lines(Path.of(path)).anyMatch(lines -> lines.contains("1:2"))).isTrue();
    }

    @Test
    void if_remove_should_save_changes_in_file(@TempDir Path tempDir) throws IOException {
        String path = tempDir.resolve("disk.txt").toString();
        var map = new DickMap(path);

        map.put("1", "2");
        map.remove("1");

        Assertions.assertThat(Files.lines(Path.of(path)).anyMatch(lines -> lines.contains("1:2"))).isFalse();
    }
}

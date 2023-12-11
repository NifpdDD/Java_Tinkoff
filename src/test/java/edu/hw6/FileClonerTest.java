package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileClonerTest {

    @Test
    void clone_file_without_index(@TempDir Path tempDir) throws IOException {
        var filePath = tempDir.resolve("biba.aboba");
        Files.createFile(filePath);

        FileCloner.cloneFile(filePath);

        Assertions.assertThat(Files.exists(tempDir.resolve("biba — копия.aboba"))).isTrue();
    }

    @Test
    void clone_file_with_index(@TempDir Path tempDir) throws IOException {
        var filePath = tempDir.resolve("biba.aboba");
        Files.createFile(filePath);

        FileCloner.cloneFile(filePath);
        FileCloner.cloneFile(filePath);

        Assertions.assertThat(Files.exists(tempDir.resolve("biba — копия (1).aboba"))).isTrue();
    }
}

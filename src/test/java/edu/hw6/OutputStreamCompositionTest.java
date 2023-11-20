package edu.hw6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class OutputStreamCompositionTest {

    @Test
    void makeComposition(@TempDir Path tempDir) throws IOException {
        var filePath = tempDir.resolve("biba.aboba");

        OutputStreamComposition.makeComposition(String.valueOf(filePath));

        Assertions.assertThat(Files.readAllLines(filePath, StandardCharsets.UTF_8))
            .contains("Programming is learned by writing programs. ― Brian Kernighan");
    }
}

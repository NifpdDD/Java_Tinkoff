package edu.hw9.task2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class CountFilesTaskTest {
    @Test
    void test_count_files(@TempDir Path tempDir) throws IOException {
        createDirectoryStructure(tempDir);
        var expectedCount = 2;

        CountFilesTask countFilesTask = new CountFilesTask(tempDir.toFile());
        int result = countFilesTask.compute();

        Assertions.assertThat(result).isEqualTo(expectedCount);
    }

    private void createDirectoryStructure(Path tempDir) throws IOException {
        Path subDir1 = tempDir.resolve("subdir1");
        Path subDir2 = tempDir.resolve("subdir2");

        Files.createDirectory(subDir1);
        Files.createDirectory(subDir2);


        createDummyFile(subDir1.resolve("file1.txt"));
        createDummyFile(subDir1.resolve("file2.txt"));
        createDummyFile(subDir1.resolve("file3.txt"));
        createDummyFile(subDir2.resolve("file1.txt"));
        createDummyFile(subDir2.resolve("file2.txt"));
        createDummyFile(subDir2.resolve("file3.txt"));
    }

    private void createDummyFile(Path filePath) throws IOException {
        Files.createFile(filePath);
    }

}

package edu.hw9.task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class SearchFilesTaskTest {
    @Test
    void test_search_files(@TempDir Path tempDir) throws IOException {
        createDirectoryStructure(tempDir);
        var countFiles = 6;

        SearchFilesTask searchFilesTask = new SearchFilesTask(tempDir.toFile(), -1, ".txt");
        List<File> result = searchFilesTask.compute();

        Assertions.assertThat(result).hasSize(countFiles);
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

package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static edu.hw6.task3.ExtensionMatchesFilter.extensionMatches;
import static edu.hw6.task3.IsReadableFitlter.readable;
import static edu.hw6.task3.LagerThanFilter.lagerThan;
import static edu.hw6.task3.MagicNumberFilter.magicNumber;
import static edu.hw6.task3.RegexContainsFilter.regexContains;

class AbstractFilterTest {
    @Test
    void if_fail_is_exists_should_found(@TempDir Path tempDir) throws IOException {
        var path = tempDir.resolve("pivo.png");
        Files.createFile(path);
        byte[] magicBytes = {(byte)  0x89, 'P', 'N', 'G'};
        final AbstractFilter regularFile = Files::isRegularFile;
        DirectoryStream.Filter<Path> filter = regularFile.and(readable())
            .and(lagerThan(-1))
            .and(extensionMatches("png"))
            .and(regexContains("p.*"));
        List<String> list = new ArrayList<>();

        try (var entries = Files.newDirectoryStream(tempDir, filter)) {
            entries.forEach(entry -> list.add(entry.getFileName().toString()));
        }

        Assertions.assertThat(list).contains("pivo.png");
    }

    @Test
    void if_fail_isnot_exists_shouldnt_found() throws IOException {
        var tempFile =("src\\main\\resources");
        byte[] magicBytes = {(byte)  0x89, 'P', 'N', 'G'};
        final AbstractFilter regularFile = Files::isRegularFile;
        DirectoryStream.Filter<Path> filter = regularFile.and(readable())
            .and(lagerThan(1))
            .and(magicNumber(magicBytes))
            .and(extensionMatches("aboba"))
            .and(regexContains("<3.*"));
        List<String> list = new ArrayList<>();

        try (var entries = Files.newDirectoryStream(Path.of(tempFile), filter)) {
            entries.forEach(entry -> list.add(entry.getFileName().toString()));
        }

        Assertions.assertThat(list).isEmpty();
    }

}

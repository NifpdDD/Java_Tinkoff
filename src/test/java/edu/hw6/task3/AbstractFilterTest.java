package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static edu.hw6.task3.ExtensionMatchesFilter.extensionMatches;
import static edu.hw6.task3.IsReadableFitlter.readable;
import static edu.hw6.task3.LagerThanFilter.lagerThan;
import static edu.hw6.task3.MagicNumberFilter.magicNumber;
import static edu.hw6.task3.RegexContainsFilter.regexContains;

class AbstractFilterTest {
    @Test
    void check_filter_chain(@TempDir Path tempDir) throws IOException {
        var tempFile =("src\\main\\resources");
        byte[] magicBytes = {(byte)  0x89, 'P', 'N', 'G'};
        final AbstractFilter regularFile = Files::isRegularFile;
        DirectoryStream.Filter<Path> filter = regularFile.and(readable())
            .and(lagerThan(3000))
            .and(magicNumber(magicBytes))
            .and(extensionMatches("*.png"))
            .and(regexContains("p.*"));

        try (var entries = Files.newDirectoryStream(Path.of(tempFile), filter)) {
            System.out.println();
            System.out.println("Files:");
            entries.forEach(System.out::println);
        }
    }

}

package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;

public class FileCloner {
    private FileCloner() {

    }

    public static void cloneFile(Path path) {
        Path directory = path.getParent();
        var result = new Result(create(path).baseName(), create(path).extension());
        Path newFilePath = getPath(result, directory);
        try {
            Files.copy(path, newFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Result create(Path originalPath) {
        String baseName = originalPath.getFileName().toString();
        String extension = "";
        int dotIndex = baseName.lastIndexOf(".");
        if (dotIndex > 0) {
            extension = baseName.substring(dotIndex);
            baseName = baseName.substring(0, dotIndex);
        }
        return new Result(baseName, extension);
    }

    @NotNull private static Path getPath(Result result, Path directory) {
        StringBuilder newFileName = new StringBuilder(result.baseName())
            .append(" — копия")
            .append(result.extension());
        int i = 1;
        Path newFilePath = directory.resolve(String.valueOf(newFileName));
        while (Files.exists(newFilePath)) {
            newFileName = new StringBuilder(result.baseName())
                .append(" — копия (")
                .append(i)
                .append(")")
                .append(result.extension());
            newFilePath = directory.resolve(String.valueOf(newFileName));
            i++;
        }
        return newFilePath;
    }

    private record Result(String baseName, String extension) {
    }
}

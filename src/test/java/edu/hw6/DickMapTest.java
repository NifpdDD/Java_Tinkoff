package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DickMapTest{
    @Test
    void if_add_should_save_changes_in_file() throws IOException {
        String path =
            "C:\\Users\\pdd\\IdeaProjects\\Java_course\\java-course-2023\\Java_Tinkoff\\src\\main\\resources\\disk.txt";
        var map = new DickMap(path);

        map.put("1", "2");

        Assertions.assertThat(Files.lines(Path.of(path)).anyMatch(lines->lines.contains("1:2"))).isTrue();
    }

    @Test
    void if_remove_should_save_changes_in_file() throws IOException {
        String path =
            "C:\\Users\\pdd\\IdeaProjects\\Java_course\\java-course-2023\\Java_Tinkoff\\src\\main\\resources\\disk.txt";
        var map = new DickMap(path);


        map.put("1", "2");
        map.remove("1");

        Assertions.assertThat(Files.lines(Path.of(path)).anyMatch(lines->lines.contains("1:2"))).isFalse();
    }
}

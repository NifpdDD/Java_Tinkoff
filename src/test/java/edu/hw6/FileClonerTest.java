package edu.hw6;

import java.nio.file.Files;
import java.nio.file.Path;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FileClonerTest {

    @Test
    void clone_file_without_index() {
        FileCloner.cloneFile(Path.of("C:\\Users\\pdd\\IdeaProjects\\Java_course\\java-course-2023\\Java_Tinkoff\\src\\main\\resources\\biba.aboba"));

        Assertions.assertThat(Files.exists(Path.of("C:\\Users\\pdd\\IdeaProjects\\Java_course\\java-course-2023\\Java_Tinkoff\\src\\main\\resources\\biba — копия.aboba"))).isTrue();
    }

    @Test
    void clone_file_with_index() {
        FileCloner.cloneFile(Path.of("src\\main\\resources\\biba.aboba"));
        FileCloner.cloneFile(Path.of("src\\main\\resources\\biba.aboba"));

        Assertions.assertThat(Files.exists(Path.of("src\\main\\resources\\biba — копия (1).aboba"))).isTrue();
    }
}

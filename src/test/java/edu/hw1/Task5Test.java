package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task5Test {

    @Test
    @DisplayName("hTsii  s aimex dpus rtni.g -> This is a mixed up string.")
    void if_valid_string1_should_return_fixed_string() {
        Task5 task5 = new Task5();
        String input = "hTsii  s aimex dpus rtni.g";
        String result = task5.fixString(input);
        Assertions.assertThat(result).isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("badce -> abcde ")
    public void if_valid_string2_should_return_fixed_string() {
        Task5 task5 = new Task5();
        String input = "badce";
        String result = task5.fixString(input);
        Assertions.assertThat(result).isEqualTo("abcde");
    }

    @Test
    public void if_empty_string_should_return_error_message() {
        Task5 task5 = new Task5();
        String input = "";
        String result = task5.fixString(input);
        Assertions.assertThat(result).isEqualTo("Строка пустая или состоит из одних пробелов");
    }

    @Test
    public void if_whitespace_string_should_return_error_message() {
        Task5 task5 = new Task5();
        String input = "   ";
        String result = task5.fixString(input);
        Assertions.assertThat(result).isEqualTo("Строка пустая или состоит из одних пробелов");
    }

    @Test
    public void if_null_string_should_throw_null_pointer_exception() {
        Task5 task5 = new Task5();
        String input = null;
        Assertions.assertThatThrownBy(() -> {
            task5.fixString(null);
        }).isInstanceOf(NullPointerException.class);
    }
}

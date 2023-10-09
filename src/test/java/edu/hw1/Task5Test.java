package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class Task5Test {

    @Test
    @DisplayName("hTsii  s aimex dpus rtni.g -> This is a mixed up string.")
    public void ifValidString1_ShouldReturnFixedString() {
        Task5 task5 = new Task5();
        String input = "hTsii  s aimex dpus rtni.g";
        String result = task5.fixString(input);
        Assertions.assertThat(result).isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("badce -> abcde ")
    public void ifValidString2_ShouldReturnFixedString() {
        Task5 task5 = new Task5();
        String input = "badce";
        String result = task5.fixString(input);
        Assertions.assertThat(result).isEqualTo("abcde");
    }

    @Test
    public void ifEmptyString_ShouldReturnErrorMessage() {
        Task5 task5 = new Task5();
        String input = "";
        String result = task5.fixString(input);
        Assertions.assertThat(result).isEqualTo("Строка пустая или состоит из одних пробелов");
    }

    @Test
    public void ifWhitespaceString_ShouldReturnErrorMessage() {
        Task5 task5 = new Task5();
        String input = "   ";
        String result = task5.fixString(input);
        Assertions.assertThat(result).isEqualTo("Строка пустая или состоит из одних пробелов");
    }

    @Test
    public void ifNullString_ShouldThrowNullPointerException() {
        Task5 task5 = new Task5();
        String input = null;
        Assertions.assertThatThrownBy(() -> {
            task5.fixString(null);
        }).isInstanceOf(
            NullPointerException.class);

    }
}

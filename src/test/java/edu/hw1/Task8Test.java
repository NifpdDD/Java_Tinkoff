package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task8Test {
    @Test
    @DisplayName("(17, 2) -> 6")
    void ifRotateLeft17_ShouldReturn2() {
        Task8 task8 = new Task8();
        int n = 17;
        int shift = 2;
        int result = task8.rotateLeft(n, shift);
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void ifRotateLeftWithNegativeShift_ShouldReturnMunis1() {
        Task8 task8 = new Task8();
        int n = 10;
        int shift = -2;
        int result = task8.rotateLeft(n, shift);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("(10, 2) -> 10")
    void tifRotateRight10_ShouldReturn10() {
        Task8 task8 = new Task8();
        int n = 10;
        int shift = 2;
        int result = task8.rotateRight(n, shift);
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void ifRotateRightWithNegativeShift_ShouldReturnMunis1() {
        Task8 task8 = new Task8();
        int n = 10;
        int shift = -2;
        int result = task8.rotateRight(n, shift);
        Assertions.assertThat(result).isEqualTo(-1);
    }
    @Test
    void ifRotateLeftNegativeNubmer_ShouldReturnMunis1() {
        Task8 task8 = new Task8();
        int n = -17;
        int shift = 2;
        int result = task8.rotateLeft(n, shift);
        Assertions.assertThat(result).isEqualTo(-1);
    }
    @Test
    void ifRotateRightNegativeNubmer_ShouldReturnMunis1() {
        Task8 task8 = new Task8();
        int n = -17;
        int shift = 2;
        int result = task8.rotateRight(n, shift);
        Assertions.assertThat(result).isEqualTo(-1);
    }
    @Test
    void tifRotateRight0_ShouldReturn0() {
        Task8 task8 = new Task8();
        int n = 0;
        int shift = 50;
        int result = task8.rotateRight(n, shift);
        Assertions.assertThat(result).isEqualTo(0);
    }
    @Test
    void tifRotateLeft0_ShouldReturn0() {
        Task8 task8 = new Task8();
        int n = 0;
        int shift = 10000;
        int result = task8.rotateRight(n, shift);
        Assertions.assertThat(result).isEqualTo(0);
    }

}


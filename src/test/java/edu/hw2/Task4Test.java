package edu.hw2;

import edu.hw2.task4.CallingInfoClass;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task4Test {
    @Test
    void should_return_test_name() {
        var res = CallingInfoClass.callingInfo();

        Assertions.assertThat(res.methodName()).isEqualTo("should_return_test_name");
    }

    @Test
    void should_return_class_name() {
        var res = CallingInfoClass.callingInfo();

        Assertions.assertThat(res.className()).isEqualTo("edu.hw2.Task4Test");
    }
}

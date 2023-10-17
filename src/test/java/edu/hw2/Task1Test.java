package edu.hw2;

import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {
    @Test void if_const_should_return_const() {
        int number = 1;

        var cosnant = new Constant(number);

        Assertions.assertThat(cosnant.evaluate()).isEqualTo(1);
    }

    @Test void if_neg_const_should_return_neg_const() {
        var constant = new Constant(7);

        var negconst = new Negate(constant);

        Assertions.assertThat(negconst.evaluate()).isEqualTo(-7);

    }

    @Test void if_exp_should_return_exp() {
        var a = new Constant(2);

        var exp = new Exponent(a, new Negate(a));

        Assertions.assertThat(exp.evaluate()).isEqualTo(Math.pow(2, -2));
    }

    @Test void if_add_should_return_add() {
        var a = new Negate(new Constant(1));
        var b = new Constant(7);

        var add = new Addition(a, b);

        Assertions.assertThat(add.evaluate()).isEqualTo(-1 + 7);
    }

    @Test void if_mult_should_return_mult() {
        var two = new Constant(2);
        var four = new Constant(4);
        var sumTwoFour = new Addition(two, four);
        var negOne = new Negate(new Constant(1));
        var mult = new Multiplication(sumTwoFour, negOne);
        Assertions.assertThat(mult.evaluate()).isEqualTo((2 + 4) * (-1));
    }
}

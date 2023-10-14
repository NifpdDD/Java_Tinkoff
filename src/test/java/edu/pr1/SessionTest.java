package edu.pr1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class SessionTest {

    @ParameterizedTest
    @CsvSource({"a, 5", "aaa1, 6", "' ', 7","pivo,-1000"})
    void if_word_is_not_correct_should_return_e(String word, int attempt) {
        Assertions.assertThatThrownBy(() -> new Session(word, attempt))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void if_guess_is_correct_should_open_the_word() {
        Session session = new Session("aboba", 5);
        GuessResult result = session.guess("a");
        char[] expectedUserAnswer = {'a', '*', '*', '*', 'a'};
        String expectedMessage = "Hit";
        Assertions.assertThat(result).isInstanceOf(GuessResult.SuccessfulGuess.class);
        Assertions.assertThat(result.state()).isEqualTo(expectedUserAnswer);
        Assertions.assertThat(result.message()).isEqualTo(expectedMessage);
    }
    @Test
    void if_guess_is_not_correct_should_not_open_the_word_and_inc_attempts() {
        Session session = new Session("aboba", 5);
        GuessResult result = session.guess("j");
        char[] expectedUserAnswer = {'*', '*', '*', '*', '*'};
        String expectedMessage = "Missed, mistake 1 out of 5";
        Assertions.assertThat(result).isInstanceOf(GuessResult.FailedGuess.class);
        Assertions.assertThat(result.state()).isEqualTo(expectedUserAnswer);
        Assertions.assertThat(result.message()).isEqualTo(expectedMessage);
        Assertions.assertThat(session.getAttempts()).isEqualTo(1);
    }
    @Test
    void if_win_should_show_win_message() {
        Session session = new Session("aaa", 5);
        GuessResult result = session.guess("a");
        char[] expectedUserAnswer = {'a', 'a', 'a'};
        String expectedMessage = "Congratulations! You have won!";
        Assertions.assertThat(result).isInstanceOf(GuessResult.Win.class);
        Assertions.assertThat(result.state()).isEqualTo(expectedUserAnswer);
        Assertions.assertThat(result.message()).isEqualTo(expectedMessage);
    }
    @Test
    void if_fail_should_show_failed_message() {
        Session session = new Session("dog", 1);
        GuessResult result = session.guess("l");
        char[] expectedUserAnswer = {'d', 'o', 'g'};
        String expectedMessage = "You lost";
        Assertions.assertThat(result).isInstanceOf(GuessResult.Defeat.class);
        Assertions.assertThat(result.state()).isEqualTo(expectedUserAnswer);
        Assertions.assertThat(result.message()).isEqualTo(expectedMessage);
    }



}

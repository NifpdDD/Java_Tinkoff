package edu.pr1;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {
    char[] state();

    @NotNull String message();

    record Defeat(char[] state, @NotNull String message) implements GuessResult {
    }

    record Win(char[] state, @NotNull String message) implements GuessResult {
    }

    record SuccessfulGuess(char[] state, @NotNull String message) implements GuessResult {
    }

    record FailedGuess(char[] state, @NotNull String message) implements GuessResult {
    }
}

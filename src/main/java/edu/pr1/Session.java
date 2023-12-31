package edu.pr1;

import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String answer, int maxAttempts) {
        checkWords(answer);
        if (maxAttempts <= 0) {
            throw new IllegalArgumentException("Значение maxAttempts не может быть отрицательным");
        }
        this.answer = answer;
        this.userAnswer = "*".repeat(answer.length()).toCharArray();
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    private static void checkWords(String word) {
        checkWordEmptyOrWhitespace(word);
        checkWordCorrectLength(word);
        checkWordDigits(word);
    }

    private static void checkWordEmptyOrWhitespace(String word) {
        if (word.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Word in dictionary cannot be empty or contain only whitespace:");
        }
    }

    @SuppressWarnings("MagicNumber")
    private static void checkWordCorrectLength(String word) {
        if (word.length() < 3 || word.length() >= 50) {
            throw new IllegalArgumentException(
                "Word in dictionary length should be between 3 and 49 characters. Word \"" + word
                    + "\" is not correct");
        }
    }

    private static void checkWordDigits(String word) {
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("Word cannot contain digits: \"" + word + "\"");
            }
        }
    }

    public int getAttempts() {
        return attempts;
    }

    @NotNull GuessResult guess(String guess) {
        boolean seccessfullGues = isSuccessfullGuess(guess);
        if (seccessfullGues) {
            return createSuccessRecord();
        }
        return createFailedRecord();
    }

    private boolean isSuccessfullGuess(String guess) {
        boolean seccessfullGues = false;
        for (int i = 0; i < answer.length(); i++) {
            if (Character.toLowerCase(guess.charAt(0)) == Character.toLowerCase(answer.charAt(i))) {
                userAnswer[i] = answer.charAt(i);
                seccessfullGues = true;
            }
        }
        return seccessfullGues;
    }

    @NotNull private GuessResult createFailedRecord() {
        if (isDefeat()) {
            return new GuessResult.Defeat(answer.toCharArray(), "You lost");
        }
        attempts++;
        return new GuessResult.FailedGuess(
            userAnswer,
            "Missed, mistake " + attempts + " out of " + maxAttempts
        );

    }

    @NotNull private GuessResult createSuccessRecord() {
        if (isWin()) {
            return new GuessResult.Win(userAnswer, "Congratulations! You have won!");
        }
        return new GuessResult.SuccessfulGuess(userAnswer, "Hit");

    }

    private boolean isWin() {
        return !new String(userAnswer).contains("*");
    }

    private boolean isDefeat() {
        return attempts == maxAttempts - 1;
    }

}

package edu.pr1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ConsoleHangman {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int MAX_ATTEMPTS = 1;
    private static final String[] WORDS = {"Aaa"};

    public void run() {
        Dictionary dictionary = new Dictionary(WORDS);
        Session session = new Session(dictionary.randomWord(), MAX_ATTEMPTS);
        Scanner scanner = new Scanner(System.in);
        GuessResult yourGuess = null;
        LOGGER.info("Guess a letter");
        String s = scanner.nextLine();
        do {
            try {
                if (s.length() == 1 && s.charAt(0) != ' ' && !Character.isDigit(s.charAt(0))) {
                    yourGuess = tryGuess(session, s);
                    printState(yourGuess);
                } else {
                    LOGGER.info("Wrong input! Try again!");
                }
            } catch (NoSuchElementException e) {
                LOGGER.info("You lost!");
                break;
            }
        } while (!(yourGuess instanceof GuessResult.Defeat || yourGuess instanceof GuessResult.Win));

    }

    private GuessResult tryGuess(Session session, String input) {
        return session.guess(input);
    }

    private void printState(GuessResult guess) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("The word: " + new String(guess.state()));
            LOGGER.info(guess.message());
        }
    }
}


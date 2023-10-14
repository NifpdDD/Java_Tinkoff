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
        String input;
        do {
            try {
                input = scanner.nextLine();
            } catch (NoSuchElementException e) {
                LOGGER.info("You gave up!");
                break;
            }
            if (input.length() == 1 && input.charAt(0) != ' ' && !Character.isDigit(input.charAt(0))) {
                yourGuess = tryGuess(session, input);
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("The word: " + new String(yourGuess.state()));
                    LOGGER.info(yourGuess.message());
                }
            } else {
                LOGGER.info("Wrong input! Try again!");
            }

        } while (!(yourGuess instanceof GuessResult.Defeat || yourGuess instanceof GuessResult.Win));

    }

    private GuessResult tryGuess(Session session, String input) {
        return session.guess(input);
    }

}


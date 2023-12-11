package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class Parser {
    private Parser next;

    public static Parser link(Parser first, Parser... chain) {
        Parser head = first;
        for (Parser nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract Optional<LocalDate> parseCurrect(String date);

    protected Optional<LocalDate> parse(String date) {
        var result = parseCurrect(date);
        if (result.isEmpty() && next != null) {
            return next.parse(date);
        }
        return result;
    }
}

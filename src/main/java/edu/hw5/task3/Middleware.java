package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class Middleware {
    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract Optional<LocalDate> parse(String time);

    protected Optional<LocalDate> check(String time) {
        var result = parse(time);
        if (result.isEmpty() && next != null) {
            return next.check(time);
        }
        return result;
    }
}

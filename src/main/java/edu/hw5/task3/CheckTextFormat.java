package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class CheckTextFormat extends Parser {
    @Override
    public Optional<LocalDate> parseCurrect(String date) {
        return switch (date) {
            case "today" -> Optional.of(LocalDate.now());
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            default ->  Optional.empty();
        };
    }
}

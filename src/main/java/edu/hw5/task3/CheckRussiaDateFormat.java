package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Optional;

public class CheckRussiaDateFormat extends Middleware {
    @Override
    public Optional<LocalDate> parse(String time) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("d/M/uu").toFormatter();
        try {
            return Optional.of(LocalDate.parse(time, formatter));
        }
        catch (Exception e) {
            return Optional.empty();
        }

    }

}

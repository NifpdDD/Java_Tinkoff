package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class CheckEuropeDateFormat extends Middleware {

    public Optional<LocalDate> getLocalDate(String time, String pattern) {
        if (time.matches(pattern)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return Optional.of(LocalDate.parse(time, formatter));
        }
        return Optional.empty();
    }

    @Override
    public Optional<LocalDate> parse(String time) {
        var pattern = "^\\d{4}-\\d{1,2}-\\d{1,2}$";
        return getLocalDate(time, pattern);
    }

}

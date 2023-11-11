package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.apache.commons.validator.GenericValidator;

public class CheckRussiaDateFormat extends Parser {
    @Override
    public Optional<LocalDate> parseCurrect(String date) {
        DateTimeFormatter formatter2Y = DateTimeFormatter.ofPattern("d/M/[yyyy][yyy][yy][y]");
        if (GenericValidator.isDate(date, "d/M/y", false)) {
                return Optional.of(LocalDate.parse(date, formatter2Y));
        }
        return Optional.empty();
    }
}

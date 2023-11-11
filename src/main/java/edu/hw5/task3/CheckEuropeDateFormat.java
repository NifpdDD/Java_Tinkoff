package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Optional;
import org.apache.commons.validator.GenericValidator;

public class CheckEuropeDateFormat extends Parser {

    @Override
    public Optional<LocalDate> parseCurrect(String date) {
        var format = "y-M-d";
        DateTimeFormatter formatter =
            new DateTimeFormatterBuilder().appendPattern(format).toFormatter();
        if (GenericValidator.isDate(date, format, false)) {
            return Optional.of(LocalDate.parse(date, formatter));
        }
        return Optional.empty();
    }

}

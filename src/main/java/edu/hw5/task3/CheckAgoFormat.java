package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class CheckAgoFormat extends Parser {
    @Override
    public Optional<LocalDate> parseCurrect(String date) {
        var pattern = Pattern.compile("([1-9]{1,10}) day(s)? ago");
        var matcher = pattern.matcher(date);
        if (matcher.matches()) {
            return Optional.of(LocalDate.now().minusDays(Long.parseLong(matcher.group(1))));
        }
        return Optional.empty();
    }
}


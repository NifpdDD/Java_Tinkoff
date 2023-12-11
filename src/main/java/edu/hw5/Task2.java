package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @SuppressWarnings("MagicNumber")
    public List<LocalDate> getAll13Friday(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException();
        }
        List<LocalDate> friday13List = new ArrayList<>();
        for (int currentYear = year; currentYear <= year + 1; currentYear++) {
            for (int month = 1; month <= 12; month++) {
                LocalDate date = LocalDate.of(currentYear, month, 13);
                if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    friday13List.add(date);
                }
            }
        }
        return friday13List;
    }

    public LocalDate getNext13Frifday(String time) {
        try {
            var date = LocalDate.parse(time, FORMATTER);
            var dates = getAll13Friday(date.getYear());
            LocalDate nextFriday = date.with(dates.get(0).getMonth());
            for (var friday : dates) {
                if (friday.isAfter(date)) {
                    nextFriday = friday;
                    break;
                }
            }
            return nextFriday;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}

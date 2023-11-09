package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    @SuppressWarnings("MagicNumber")
    public List<LocalDate> getAll13Friday(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException();
        }
        List<LocalDate> friday13List = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                friday13List.add(date);
            }
        }

        return friday13List;
    }

    public LocalDate getNext13Frifday(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            var date = LocalDate.parse(time, formatter);
            var dates = getAll13Friday(date.getYear());
            LocalDate nextFriday = date;
            while (!dates.contains(date)) {
                nextFriday = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
                date = nextFriday;
            }
            return nextFriday;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}

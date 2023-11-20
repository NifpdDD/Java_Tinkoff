package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    public String getAverageVisitDuration(List<String> times) {
        Duration totalDuration = Duration.ZERO;
        for (String line : times) {
            String[] parts = line.split(" - ");
            try {
                LocalDateTime start = LocalDateTime.parse(parts[0], FORMATTER);
                LocalDateTime end = LocalDateTime.parse(parts[1], FORMATTER);
                Duration duration = Duration.between(start, end);
                totalDuration = totalDuration.plus(duration);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
        var averageDuration = totalDuration.dividedBy(times.size());
        var averageHours = averageDuration.toHours();
        var averageMinutes = averageDuration.toMinutesPart();
        return String.format("%d:%02d", averageHours, averageMinutes);

    }
}

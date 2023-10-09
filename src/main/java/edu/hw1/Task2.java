package edu.hw1;

import java.util.Objects;


public final class Task2 {
    public Task2() {
    }

    private static final int SECONDS_IN_MUNUTE = 60;

    public int minutesToSeconds(String time) {
        Objects.requireNonNull(time);
        String[] parts = time.split(":");
        if (parts.length != 2) {
            return -1;
        }
        try {
            int minutes = Integer.parseUnsignedInt(parts[0]);
            int seconds = Integer.parseUnsignedInt(parts[1]);
            if (seconds >= SECONDS_IN_MUNUTE) {
                return -1;
            }
            return minutes * SECONDS_IN_MUNUTE + seconds;
        } catch (NumberFormatException ignored) {
            return -1;
        }

    }

}

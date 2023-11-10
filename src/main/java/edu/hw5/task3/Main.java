package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        var m = Middleware.link(new CheckEuropeDateFormat(), new CheckRussiaDateFormat());
        var f =m.check("/02/02");
        return;
    }
}

package edu.pr3.stats;

import java.util.List;

public interface Stats {
    List<List<String>> getStats(int k);

    List<String> getHeader();

    String getTitle();
}

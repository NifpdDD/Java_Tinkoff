package edu.pr3;

import java.io.BufferedReader;
import java.io.IOException;

public class DocAnalyser {
    private DocAnalyser() {

    }

    public static void analyseDoc(
        BufferedReader reader,
        StatsManager statsManager,
        InputAnalyzer inputAnalyzer
    ) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            var log = LogParse.parse(line);
            statsManager.collectionOfStatistics(log, inputAnalyzer);
        }
    }
}

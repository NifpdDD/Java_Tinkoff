package edu.pr3;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import picocli.CommandLine;

@Getter
@CommandLine.Command(name = "LogAnalyzer", description = "Parse and analyze NGINX log files")
public class InputAnalyzer {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
    public static final String TIME = "T00:00:00Z";

    @CommandLine.Option(names = {"--path"}, description = "Path or URL to NGINX log files", required = true)
    private String logPath;

    @CommandLine.Option(names = {"--from"},
                        description = "Start date (format: yyyy-MM-dd)",
                        required = false,
                        defaultValue = "-")
    private String fromDate;

    @CommandLine.Option(names = {"--to"},
                        description = "End date (format: yyyy-MM-dd)",
                        required = false,
                        defaultValue = "-")
    private String toDate;

    @CommandLine.Option(names = {"--format"},
                        description = "Output format (markdown or adoc)",
                        defaultValue = "markdown")
    private String outputFormat;

    public static InputAnalyzer parseArgs(String[] args) {
        var inputAnalyzer = new InputAnalyzer();
        CommandLine commandLine = new CommandLine(inputAnalyzer);
        commandLine.parse(args);
        return inputAnalyzer;
    }

    public void setOutputFormat(String format) {
        outputFormat = format;
    }

    public void setFromDate(String s) {
        fromDate = s;
    }

    public void setToDate(String s) {
        toDate = s;
    }

    public LocalDateTime getFromDateAsOffsetDateTime() {
        if (fromDate.equals("-")) {
            return LocalDateTime.MIN.atOffset(ZoneOffset.MIN).toLocalDateTime();
        }
        return OffsetDateTime.parse(fromDate + TIME, DATE_TIME_FORMATTER).toLocalDateTime();
    }

    public LocalDateTime getToDateAsOffsetDateTime() {
        if (toDate.equals("-")) {
            return LocalDateTime.MAX.atOffset(ZoneOffset.MAX).toLocalDateTime();
        }
        return OffsetDateTime.parse(toDate + TIME, DATE_TIME_FORMATTER).toLocalDateTime();
    }
}

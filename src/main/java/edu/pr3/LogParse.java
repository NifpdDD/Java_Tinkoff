package edu.pr3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParse {
    public static final String LOG_PATTERN =
        "^(\\S+) - (\\S+) \\[([^]]+)] \"([^\"]+)\" (\\d+) (\\d+) \"([^\"]+)\" \"([^\"]+)\"$";
    public static final Pattern COMPILE = Pattern.compile(LOG_PATTERN);
    public static final DateTimeFormatter DATE_TIME_FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

    private LogParse() {
    }

    @SuppressWarnings("MagicNumber")
    public static Log parse(String logLine) {
        Matcher matcher = COMPILE.matcher(logLine);
        if (!matcher.matches()) {
            return null;
        }
        String remoteAddr = matcher.group(1);
        String remoteUser = matcher.group(2);
        var timeLocal = getOffsetDateTime(matcher.group(3));
        String request = matcher.group(4);
        int status = Integer.parseInt(matcher.group(5));
        long bodyBytesSent = Long.parseLong(matcher.group(6));
        String httpReferer = matcher.group(7);
        String httpUserAgent = matcher.group(8);
        return new Log.LogBuilder().remoteAddr(remoteAddr).remoteUser(remoteUser).dateTimeLocal(timeLocal)
            .request(request).status(status).bodyBytesSent(bodyBytesSent).httpReferer(httpReferer)
            .httpUserAgent(httpUserAgent).build();
    }

    private static OffsetDateTime getOffsetDateTime(String dateTime) {
        return OffsetDateTime.parse(dateTime, DATE_TIME_FORMATTER);
    }

}


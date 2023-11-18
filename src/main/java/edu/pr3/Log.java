package edu.pr3;

import java.time.OffsetDateTime;

public record Log(String remoteAddr, String remoteUser, OffsetDateTime dateTimeLocal, String request,
                  int status, long bodyBytesSent, String httpReferer, String httpUserAgent) {
}

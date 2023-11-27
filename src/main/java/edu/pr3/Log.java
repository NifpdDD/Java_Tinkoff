package edu.pr3;

import lombok.Builder;
import java.time.OffsetDateTime;
@Builder
public record Log(String remoteAddr, String remoteUser, OffsetDateTime dateTimeLocal, String request,
                  int status, long bodyBytesSent, String httpReferer, String httpUserAgent) {
}

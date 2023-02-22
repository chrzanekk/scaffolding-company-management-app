package pl.com.chrzanowski.scma.util;

import java.time.Instant;

public class DateTimeUtil {

    public static Instant setDateTimeIfNotExists(Instant localDateTime) {
        if (localDateTime != null) {
            return localDateTime;
        }
        return Instant.now();
    }
}

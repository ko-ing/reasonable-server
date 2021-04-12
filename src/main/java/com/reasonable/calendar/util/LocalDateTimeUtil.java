package com.reasonable.calendar.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class LocalDateTimeUtil {
    public static LocalDateTime longToLDT(Long date) {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(date), TimeZone.getDefault().toZoneId());
    }
}

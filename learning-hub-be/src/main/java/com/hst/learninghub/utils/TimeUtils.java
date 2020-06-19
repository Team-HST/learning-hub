package com.hst.learninghub.utils;

import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@UtilityClass
public class TimeUtils {

    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    public static LocalDate parse(String source) {
        return parse(source, DEFAULT_DATE_PATTERN);
    }

    public static LocalDate parse(String source, String pattern) {
        return LocalDate.parse(source, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * LocalDateTime > Date 변환
     * @param localDateTime
     * @return Date
     */
    public static Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}

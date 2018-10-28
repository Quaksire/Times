package com.quaksire.times;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Times {
    /**
     * Pre-defined format dd/MM/yyyy HH:mm
     */
    public static final String FORMAT_ddMMyyyyHHmm = "dd/MM/yyyy HH:mm";

    /**
     * Pre-defined format dd MMM yyyy HH:mm
     */
    public static final String FORMAT_ddMMMyyyyHHmm = "dd MMM yyyy HH:mm";

    /**
     * Pre-defined format dd/MM/yyyy
     */
    public static final String FORMAT_ddMMyyyy = "dd/MM/yyyy";

    /**
     * Pre-defined format dd MMM yyyy
     */
    public static final String FORMAT_ddMMMyyyy = "dd MMM yyyy";

    /**
     * Pre-defined format for logs
     */
    public static final String FORMAT_ddMMyyyyHHmmSSmm = "dd/MM/yyyy HH:mm:ss:mmm";

    /**
     * Second timestamp : 1000 milliseconds
     */
    public static final long SECOND = 1000;

    /**
     * Minute in milliseconds
     */
    public static final long MINUTE = SECOND * 60;

    /**
     * Hour in milliseconds
     */
    public static final long HOUR = MINUTE * 60;

    /**
     * Day in milliseconds
     */
    public static final long DAY = HOUR * 24;

    /**
     * Parse string date into different string date
     * @param outputFormat Output format
     * @param inputFormat Input format
     * @param timestamp String to parse
     * @return String with output format
     * @throws ParseException if input cannot be parsed
     */
    public static String parse(String outputFormat, String inputFormat, String timestamp) throws ParseException {
        return toDateFormat(toSimpleDateFormat(outputFormat), toTime(inputFormat, timestamp));
    }

    /**
     * Parse timestamp into defined format
     * @param format format of the output
     * @param timestamp milliseconds to parse
     * @return String parsed in a format
     */
    public static String parse(String format, long timestamp) {
        return toDateFormat(toSimpleDateFormat(format), new Date(timestamp));
    }

    /**
     * Create a new date based on input timestamp based on a format
     * @param format Format of the date
     * @param timestamp Timestamp to parse
     * @return Date
     * @throws ParseException if timestamp cannot be parsed
     */
    private static Date toTime(String format, String timestamp) throws ParseException {
        return new Date(toSimpleDateFormat(format).parse(timestamp).getTime());
    }

    /**
     * Create a SimpleDateFormat using Locale.UK
     * @param format String format
     * @return SimpleDateFormat using Locale.UK
     */
    private static SimpleDateFormat toSimpleDateFormat(String format) {
        return toSimpleDateFormat(format, Locale.UK);
    }

    /**
     * Create a SimpleDateFormat
     * @param format format to parse
     * @param locale Locale of the date
     * @return SimpleDateFormat with format and locale specific
     */
    private static SimpleDateFormat toSimpleDateFormat(String format, Locale locale) {
        return new SimpleDateFormat(format, locale);
    }

    /**
     * format a date into specific format
     * @param dateFormat Format of the output
     * @param date Date to parse
     * @return String representation of the date in specific format
     */
    private static String toDateFormat(SimpleDateFormat dateFormat, Date date) {
        return dateFormat.format(date);
    }

    /**
     * Get Start of day timestamp in milliseconds
     * @return milliseconds representation of start of the day
     */
    public static long getStartOfDay() {
        Calendar calendar = Calendar.getInstance(Locale.UK);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime().getTime();
    }

    /**
     * Get End of day timestamp in milliseconds
     * @return milliseconds representation of end of the day
     */
    public static long getEndOfDay() {
        Calendar calendar = Calendar.getInstance(Locale.UK);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 23, 59, 59);
        return calendar.getTime().getTime();
    }
}

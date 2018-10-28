package com.quaksire.times;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;

public class TimesTest {
    @Test
    public void canGet1Second() {
        Assert.assertEquals(1000, Times.SECOND);
    }

    @Test
    public void canGet1Minute() {
        Assert.assertEquals(1000 * 60, Times.MINUTE);
    }

    @Test
    public void canGet1Hour() {
        Assert.assertEquals(1000 * 60 * 60, Times.HOUR);
    }

    @Test
    public void canGet1Day() {
        Assert.assertEquals(1000 * 60 * 60 * 24, Times.DAY);
    }

    @Test
    public void canParseStringIntoTheCorrectStringDate() throws ParseException {
        String toParse = "20/08/1986 13:30";

        Assert.assertEquals("20 Aug 1986 13:30", Times.parse(Times.FORMAT_ddMMMyyyyHHmm, Times.FORMAT_ddMMyyyyHHmm, toParse));
    }

    @Test
    public void canParseLongIntoStringDate() {
        long timestamp = 1512577195721L;
        Times.parse(Times.FORMAT_ddMMMyyyyHHmm, timestamp);

        Assert.assertEquals("06 Dec 2017 16:19", Times.parse(Times.FORMAT_ddMMMyyyyHHmm, timestamp));
    }

    @Test
    public void canGetBeginOfDay() {
        Calendar calendar = Calendar.getInstance(Locale.UK);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);

        Assert.assertEquals((int) (calendar.getTime().getTime() / 1000), (int) (Times.getStartOfDay() / 1000));
    }

    @Test
    public void canGetEndOfDay() {
        Calendar calendar = Calendar.getInstance(Locale.UK);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 23, 59, 59);

        Assert.assertEquals( (int) (calendar.getTime().getTime() / 1000), (int) (Times.getEndOfDay() / 1000));
    }
}

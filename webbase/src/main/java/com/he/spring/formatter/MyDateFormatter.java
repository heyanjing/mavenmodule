package com.he.spring.formatter;

import org.springframework.format.Formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gantianxing on 2017/6/13.
 */
public class MyDateFormatter implements Formatter<Date> {

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
        System.out.println("parse");
        try {
            return df.parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException(
                    "invalid date format.");
        }
    }

    @Override
    public String print(Date date, Locale locale) {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
        System.out.println("format");
        return df.format(date);
    }


    /**
     * Constant for full style pattern.
     */
    public static final int FULL = 0;
    /**
     * Constant for long style pattern.
     */
    public static final int LONG = 1;
    /**
     * Constant for medium style pattern.
     */
    public static final int MEDIUM = 2;
    /**
     * Constant for short style pattern.
     */
    public static final int SHORT = 3;
    /**
     * Constant for default style pattern.  Its value is MEDIUM.
     */
    public static final int DEFAULT = MEDIUM;

    //en:Jun 13, 2017 9:40:57 PM  中国：2017-6-13 21:41:30
    public static void main(String[] args) throws ParseException {
        Date dt = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINA);
        DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
        DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CHINA);
        DateFormat df3 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.CHINA);
        DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
        System.out.println(df.format(dt));
        System.out.println(df1.format(dt));
        System.out.println(df2.format(dt));
        System.out.println(df3.format(dt));
        System.out.println(df4.format(dt));
//        System.out.println(df.parse("2017-06-13 21:41:30"));
    }
}

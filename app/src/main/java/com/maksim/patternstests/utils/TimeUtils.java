package com.maksim.patternstests.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Maksim Novikov on 16-Feb-18.
 */

public class TimeUtils {

    public static final String FULL_TIME_FORMAT = "EEE, dd MMM HH:mm";

    private TimeUtils(){}

    public static String getFormattedTime(long millis, String format){
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
        String dateString = formatter.format(new Date(millis));
        return dateString;
    }
}

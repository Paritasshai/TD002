package com.tamdai.model.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {

    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance(Locale.US);
        return cal.getTime();
    }

    public static Date minus(Date date, int offset) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(getCurrentDate());
        cal.add(Calendar.DATE, (-1 * offset));

        return cal.getTime();
    }

    public static String date2str(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String formatted = dateFormat.format(date);

        return formatted;
    }
}

package com.esoft.example.i;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
public class DateFormatter implements Formatter<Date> {

    private String datePattern;

    private SimpleDateFormat dateFormat;

    public DateFormatter(String datePattern){
        this.datePattern=datePattern;
        this.dateFormat = new SimpleDateFormat(datePattern);
    }

    public Date parse(String s, Locale locale) throws ParseException {
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
           throw new IllegalArgumentException();
        }
    }

    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}

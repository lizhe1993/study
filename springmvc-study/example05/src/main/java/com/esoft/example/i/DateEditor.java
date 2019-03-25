package com.esoft.example.i;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
public class DateEditor extends PropertyEditorSupport {


    private String datePattern;

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    public DateEditor(String datePattern){
        this.datePattern = datePattern;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
            Date date = dateFormat.parse(text);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

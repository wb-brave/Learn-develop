package cn.wb.spring.first.sample.dateConvert;

import java.util.Date;

public class DateCon {

    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {

        return "date " + date;
    }
}

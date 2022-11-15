package com.wufuqiang.dateformat;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    /**
     * 获取当天0点的时间
     * @return
     */
    public static LocalDateTime getTodayBegin(){
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }

    public static String getTodayBegin(String format){
        return getDateString(format,getTodayBegin());
    }

    /**
     * 获取昨天0点的时间
     * @return
     */
    public LocalDateTime getYesterdayBegin(){
        return LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);
    }

    public LocalDateTime getHourAgo(int hour){
        return LocalDateTime.now().minusHours(hour);
    }

    public static LocalDateTime getCurrentHour(){
        return LocalDateTime.now().toLocalDate().atTime(LocalDateTime.now().getHour(),0,0);
    }


    public static String getDateString(){
        return DateTimeFormatter.ofPattern("YYYY-MM-dd").format(LocalDateTime.now());
    }

    public static String getDateString(String format,LocalDateTime time){
        return DateTimeFormatter.ofPattern(format).format(time);
    }

    // 获取当前小时和分钟  21:06
    public static String getCurrentHourMinute(){
        return DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now());
    }

    @Test
    public void getCurrentHourStr(){
        // 获取当前时间，当前小时：21
        long l = System.currentTimeMillis();
        int hour = LocalDateTime.now().getHour();
        System.out.println("当前小时："+hour);
    }

    public static void main(String[] args) {
        LocalDateTime currentHour = DateHelper.getCurrentHour();
        String currentDateStr = DateHelper.getDateString("yyyy-MM-dd HH:mm:ss", currentHour);
        System.out.println(currentDateStr);

        String currentHourMinute = getCurrentHourMinute();
        System.out.println(currentHourMinute);

        System.out.println("20:35".compareTo( currentHourMinute) < 0);
    }

}

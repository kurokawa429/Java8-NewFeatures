package org.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
    @Test
    public void test1(){
        //获取当前日期时间    格式为：2023-04-13
        LocalDate localDate = LocalDate.now();

        //LocalDate转String
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String localDateFormat = localDate.format(dtf);

        //String转LocalDate
        String time = "2023年4月14日";
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy年M月dd日");
        LocalDate localDate1 = LocalDate.parse(time,dtf1);
        System.out.println(localDate1);

    }
}

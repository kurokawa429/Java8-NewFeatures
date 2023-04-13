package org.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    @Test
    public void test1(){
        //获取当前日期时间    格式为：2023-04-13T16:09:56.579511400
        LocalDateTime localDateTime = LocalDateTime.now();

        //LocalDateTime转String
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HH:ss:mm");
        String localDateTimeFormat = localDateTime.format(dtf);

        //String转LocalDateTime转String
        String time = "2023年04月13日 16点17分40秒";
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH点ss分mm秒");
        LocalDateTime timeF = LocalDateTime.parse(time, dtf1);
    }
}

package StringDateTime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * jdk8中日期时间API的测试
 */

public class JDK8DateTimeTest {
    /*
    LocalDate、LocalTime、LocalDateTime 的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
        2.类似于Calendar
     */
    @Test
    public void test1() {
        // now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate); // 2020-10-24
        System.out.println(localTime); // 20:20:51.033
        System.out.println(localDateTime); // 2020-10-24T20:20:51.033

        // of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1); // 2020-10-06T13:23:43


        // getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth()); // 24
        System.out.println(localDateTime.getDayOfWeek());  // SATURDAY
        System.out.println(localDateTime.getMonth());      // OCTOBER
        System.out.println(localDateTime.getMonthValue()); // 10
        System.out.println(localDateTime.getMinute());     // 20

        // 体现不可变性
        // withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);  // 2020-10-24
        System.out.println(localDate1); // 2020-10-22


        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);  // 2020-10-24T20:20:51.033
        System.out.println(localDateTime2); // 2020-10-24T04:20:51.033

        // 不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);  // 2020-10-24T20:20:51.033
        System.out.println(localDateTime3); // 2021-01-24T20:20:51.033

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);  // 2020-10-24T20:20:51.033
        System.out.println(localDateTime4); // 2020-10-18T20:20:51.033
    }




    /*
    Instant的使用
    类似于java.util.Date类
     */
    @Test
    public void test2() {
        // now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant); // 2020-10-24T12:24:53.369Z

        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2020-10-24T20:24:53.369+08:00

        // toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);  // 1603542293369

        // ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1550475314878L);
        System.out.println(instant1); // 2019-02-18T07:35:14.878Z
    }




    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test3() {
        // 方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);  // 2020-10-24T20:35:04.254
        System.out.println(str1);           // 2020-10-24T20:35:04.254

        // 解析：字符串 -->日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse); // {},ISO resolved to 2019-02-18T15:42:18.797



        // 方式二：本地化相关的格式。如：ofLocalizedDateTime()
        // FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        // 格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2); // 2020年10月24日 下午08时35分04秒

        // 本地化相关的格式。如：ofLocalizedDate()
        // FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        // 格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3); // 2020-10-24



        // 方式三(重点！)：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4); // 2020-10-24 08:35:04

        // 解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor); // {MicroOfSecond=0, NanoOfSecond=0, MinuteOfHour=52, MilliOfSecond=0, SecondOfMinute=9, HourOfAmPm=3},ISO resolved to 2019-02-18
    }
}

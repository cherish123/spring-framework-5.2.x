package org.example.newdate02;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Test {
	public static void main(String[] args) {
		//todo 16:25:46.448(带纳秒值)
		LocalTime todayTimeWithMillisTIme = LocalTime.now();
		//todo 16:28：48(不带纳秒值)
		LocalTime todayTimeWithoutMillisTIme = LocalTime.now().withNano(0);

		//todo 转化为时间戳   毫秒值
		long time = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
		System.out.println("时间戳："+time);
		long time2 = System.currentTimeMillis();

		//todo 时间戳转化为localdatetime
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss.SSS");
		System.out.println(dateTimeFormatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.of("Asia/Shanghai"))));
	}
}

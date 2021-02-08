package org.example.newdate03;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Test {
	public static void main(String[] args) {
		test03();

	}

	/**
	 * 基本操作
	 */
	private static void test(){
		// todo 从默认时区的系统时钟获取当前的日期时间，不用考虑时区差
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		System.out.println(now.getYear());;
		System.out.println(now.getMonthValue());
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getHour());
		System.out.println(now.getMonth());
		System.out.println(now.getSecond());
		System.out.println(now.getNano());

		//todo 手动创建一个LocalDateTime实例
		LocalDateTime dateTime1 = LocalDateTime.of(2017, 12, 17, 9, 31, 31, 32);
		System.out.println(dateTime1);
		//todo 进行加操作
		LocalDateTime dateTime2 = dateTime1.plusDays(12);
		System.out.println(dateTime2);
		//todo 进行减操作
		LocalDateTime dateTime3 = dateTime1.minusYears(1);
		System.out.println(dateTime3);
	}

	/**
	 * 获取毫秒值
	 */
	private static void test02(){
		//todo 时间戳 1970年1月1日 00：00：00 到某一个时间点的毫秒值
		// 默认获取UTC时区
		Instant now = Instant.now();
		System.out.println(now);

		System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
		System.out.println(System.currentTimeMillis());

		System.out.println(Instant.now().toEpochMilli());
		System.out.println(Instant.now().atOffset(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
	}

	/**
	 * 计算时间间隔
	 */
	private static void test03(){
		//Duration计算两个时间间隔
		//Period计算两个日期之间的间隔
		Instant start = Instant.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant end = Instant.now();
		Duration between = Duration.between(start, end);
		System.out.println("时间间隔是："+between.getSeconds());
		System.out.println("时间间隔毫秒是："+between.toMillis());
		System.out.println("==============================================");

		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.of(2016, 12, 12);
		Period period = Period.between(date1, date2);
		System.out.println("日期间隔是："+period.getYears());


	}

	/**
	 * 格式化
	 */
	private static void test06() {
		//todo DateTimeFormatter : 格式化时间/日期
		//自定义格式
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		String format1 = dtf.format(ldt);
		String format2 = ldt.format(dtf);
		System.out.println(format1);
		System.out.println(format2);


		//todo 使用api提供的格式
		DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
		String format3 = isoDate.format(ldt);
		System.out.println(format3);

		//todo 解析字符串to时间
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format4 = dateTimeFormatter.format(ldt);
		LocalDateTime parse = LocalDateTime.parse("2017-09-28 17:07:05", dateTimeFormatter);
		System.out.println("LocalDateTime转成String类型的时间："+format4);
		System.out.println("String类型的时间转换成LocalDateTime："+parse);
	}
}

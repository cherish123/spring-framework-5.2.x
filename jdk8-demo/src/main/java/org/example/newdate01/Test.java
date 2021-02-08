package org.example.newdate01;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Test {
	public static void main(String[] args) {
		//todo 获取当前日期，只包含年月日 固定格式 yyyy-MM-dd  2018-05-04
		LocalDate today = LocalDate.now();
		System.out.println(today);

		//todo 根据年月日取日期，5月就是5
		LocalDate oldDate = LocalDate.of(2018, 5, 1);

		//todo 根据字符串取：默认格式yyyy-MM-dd，02不能写成2
		LocalDate yesteday = LocalDate.parse("2018-05-03");

		//todo 如果不是闰年 传入29号也会报错
//		LocalDate localDate = LocalDate.parse("2018-02-29");

		//todo ========================= 日期转换
		//todo 取本月第一天
		LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
		//todo 取本月第二天
		LocalDate secondDayOfMonth = today.withDayOfMonth(2);
		//todo 去本月最后一天,再也不用计算是29，30，还是31
		LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
		//todo 取下一天
		LocalDate nestDay = lastDayOfMonth.plusDays(1);
		//todo 取2018年10月第一个周三  2018-10-03
		LocalDate firstWed = LocalDate.parse("2018-10-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.WEDNESDAY));


	}
}

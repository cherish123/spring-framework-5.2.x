package org.example.function03;

import java.util.Arrays;
import java.util.function.Function;

public class Test03 {
	public static void main(String[] args) {
		//todo 数组引用
		Function<Integer,String[]> func = (x)->new String[x];
		Function<Integer,String[]> func2 = String[]::new;
		String[] strArr = func2.apply(10);
		Arrays.stream(strArr).forEach(System.out::println);

	}
}

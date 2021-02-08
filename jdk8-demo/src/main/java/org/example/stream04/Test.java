package org.example.stream04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		//todo reduce : 规约操作
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer reduce = integers.stream().reduce(0, (x, y) -> x + y);
		System.out.println(reduce);

		//todo collect: 收集操作   把流收集成什么样子，本示例中是把流收集成一个list
		List<Integer> collect = integers.stream().collect(Collectors.toList());
		collect.stream().forEach(System.out::println);

	}
}

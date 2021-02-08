package org.example.stream03;

import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		/**
		 * 1.延迟方法 返回仍然时流
		 * 2.终结方法，返回void或者是非流
		 */
		Stream<String> stringStream = Stream.of("三七", "人参", "鹿茸", "紫河车");
		//todo 如果stream只能使用一次
		//System.out.println("一共"+stringStream.count()+"味中药");
		stringStream.forEach(System.out::println);

		//todo stream map
		Stream<String> stringStream1 = Stream.of("12", "2", "3", "22");
		stringStream1.map(Integer::parseInt).forEach(System.out::println);
		System.out.println("============================================");

		//todo stream limit
		Stream<String> stringStream2 = Stream.of("12", "2", "3", "22");
		stringStream2.map(something->Integer.parseInt(something)).limit(3).forEach(something-> System.out.println(something));
		System.out.println("============================================");

		//todo stream skip
		Stream<String> stringStream3 = Stream.of("12", "2", "3", "22");
		stringStream3.map(something->Integer.parseInt(something)).limit(3).skip(2).forEach(something-> System.out.println(something));

		//todo stream concat
		Stream.concat(Stream.of(1,2,3),Stream.of("zhangsan","lisi")).forEach(System.out::print);
	}
}

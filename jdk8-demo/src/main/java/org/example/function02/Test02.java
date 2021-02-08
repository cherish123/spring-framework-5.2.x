package org.example.function02;

import java.util.function.Function;
import java.util.function.Supplier;

public class Test02 {
	public static void main(String[] args) {
		//todo 构造方法引用 类名::new
		Supplier<String> stringSupplier = ()->new String();
		System.out.println(stringSupplier.get());
		Supplier<String> stringSupplier2 = String::new;
		System.out.println(stringSupplier2.get());

		//todo 构造方法引用 类名::new  （带一个参数）
		Function<String,Integer> fun1 = (x)->new Integer(x);
		Function<String,Integer> fun2 = Integer::new;
		System.out.println(fun2.apply("1000"));
	}
}

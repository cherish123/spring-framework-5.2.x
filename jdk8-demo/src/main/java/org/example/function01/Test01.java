package org.example.function01;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Test01 {
	public static void main(String[] args) {
		//todo 若lambda体中的内容有方法已经实现了，那么可以使用 “方法引用”
		//	理解为方法引用时lambda表达式的另外一种表现形式并且其语法比lambda表达式更简单
		//	三种表现形式：
		//	1.  对象::实例方法名
		//	2.	类名::静态方法名
		//	3.	类名::实例方法名(lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时 可用)
		/**
		 * 注意：
		 * 		1.lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的的参数列表和返回值类型保持一致；
		 * 		2.若lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
		 */
		Consumer<Integer> con = (x)-> System.out.println(x);
		con.accept(100);

		//todo 方法引用-对象::实例方法
		Consumer<Integer> con2 = System.out::println;
		con2.accept(200);

		//todo 方法引用-类名::静态方法名
		BiFunction<Integer,Integer,Integer> biFunc = (x,y)->Integer.compare(x,y);
		BiFunction<Integer,Integer,Integer> biFunc2 = Integer::compare;
		Integer apply1 = biFunc.apply(100, 200);
		Integer apply2 = biFunc2.apply(500, 300);
		System.out.println("方法引用-类名::静态方法名:"+apply1);
		System.out.println("方法引用-类名::静态方法名:"+apply2);

		//todo 方法引用-类名::实例方法名
		BiFunction<String,String,Boolean> fun1 = (str1,str2)-> str1.equals(str2);
		BiFunction<String,String,Boolean> fun2 = String::equals;
		Boolean apply = fun2.apply("hello", "world");
		System.out.println("类名::实例方法名-"+apply);
	}
}

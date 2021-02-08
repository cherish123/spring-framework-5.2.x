package org.example.lambda06;

import java.util.function.Consumer;

public class Test06 {
	public static void main(String[] args) {

		//todo lambda表达式
		consumer("麻黄",something-> System.out.println(something+"汤一碗"));

		//todo lambda表达式consumer andthen
		doubleConsumer("麻黄",something-> System.out.println("华佗使用"+something+"开出:"),something-> System.out.println(something+"汤一碗"));
	}

	private static void consumer(String something, Consumer<String> consumer){
		//这个可以理解为lambda表达式的触发条件，走了这个方法才会触发真正的方法的调用。
		System.out.println("该方法在真正方法执行之前执行");
		consumer.accept(something);
	}
	private static void doubleConsumer(String something,Consumer<String> consumer1,Consumer<String> consumer2){
		consumer1.andThen(consumer2).accept(something);
	}

}

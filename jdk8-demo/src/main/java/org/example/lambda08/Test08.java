package org.example.lambda08;

import java.util.function.Function;

public class Test08 {
	public static void main(String[] args) {
		//todo lambda表达式
		int i = function("1000",(String something)->{
			return Integer.parseInt(something);
		});
		System.out.println("lambda表达式function转换： "+i);
		//todo lambda表达式 andThen
		i = andFunction("1001",something->Integer.parseInt(something),something->something%10);
		System.out.println("lambda表达式function转换： "+i);
	}

	private static Integer function(String something, Function<String,Integer> function){
		return function.apply(something);
	}

	private static Integer andFunction(String something, Function<String,Integer> function,Function<Integer,Integer> function2){
		return function.andThen(function2).apply(something);
	}
}

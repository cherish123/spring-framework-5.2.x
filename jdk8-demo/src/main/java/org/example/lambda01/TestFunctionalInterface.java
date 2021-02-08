package org.example.lambda01;

/**
 * 函数式接口
 */
@FunctionalInterface
public interface TestFunctionalInterface {

	//todo @FunctionalInterface注解要求有且只有一个抽象方法，可以有默认方法和静态方法
	public void test();

	//todo 默认方法
	default String getName(){return "人参";}

	//todo 静态方法
	static String getAlias(){return "鹿茸";}
}

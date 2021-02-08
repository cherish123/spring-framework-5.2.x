package org.example.lambda01;

public class Test {
	public static void test(TestFunctionalInterface testFunctionalInterface){
		testFunctionalInterface.test();
	}

	public static void main(String[] args) {
		//todo 传递实现类
		test(new TestFunctionalInterfaceImpl());

		//todo 匿名内部类
		test(new TestFunctionalInterface() {
			@Override
			public void test() {
				System.out.println("匿名内部类调用");
			}
		});

		//todo lambda
		test(()-> {System.out.println("lambda调用");});

		//todo 当lambda表达式只包含一条语句时，可以省略大括号，return和语句结尾的分号
		test(()-> System.out.println("lambda简化调用"));
	}
}

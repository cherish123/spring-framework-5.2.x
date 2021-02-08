package org.example.lambda03;

public class Test {

	private static void newThread(Runnable runnable){
		new Thread(runnable).start();
	}

	public static void main(String[] args) {
		//todo 普通方式
		newThread(new Runnable() {
			@Override
			public void run() {
				System.out.println("匿名内部类当前线程-"+Thread.currentThread().getName());
			}
		});
		//todo lambda表达式
		newThread(()->{System.out.println("lambda表达式当前线程-"+Thread.currentThread().getName());});
		//todo lambda表达式简化
		newThread(()-> System.out.println("lambda表达式简化"+Thread.currentThread().getName()));
	}
}

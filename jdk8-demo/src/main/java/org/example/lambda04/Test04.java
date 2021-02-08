package org.example.lambda04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 演示没有副作用
 */
public class Test04 {

	private static void newThread(Runnable runnable){
		new Thread(runnable).start();
	}

	public static void main(String[] args) {
		final Date date = new Date();
		final Map<Integer,Object> map = new HashMap<>();
		map.put(1,2);
		//todo 普通方式
		newThread(new Runnable() {
			@Override
			public void run() {
				date.setTime(1000000);
//				date = new Date();
				map.put(1,3);
//				map = new HashMap<>();
				System.out.println("匿名内部类当前线程-"+Thread.currentThread().getName());
				System.out.println(map);
			}
		});

		//todo lambda表达式
		newThread(()->{
			date.setTime(1000000);
			//date = new Date();
			map.put(1,4);
			map.put(1,new Date());
			//map = new HashMap<>();
			System.out.println("lambda表达式当前线程-"+Thread.currentThread().getName());
			System.out.println(map);
		});
	}

}

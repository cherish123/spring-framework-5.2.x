package org.example.lambda05;

import java.util.function.Supplier;

public class Test05 {

	private static String newString(Supplier<String> stringSupplier){
		return stringSupplier.get();
	}

	public static void main(String[] args) {
		//todo lambda表达式
		String str1 = newString(()->{
			return "当归";
		});
		System.out.println("lambda表达式-"+str1);
		//todo lambda表达式简化
		String str2 = newString(()->"鸡血藤");
		System.out.println("lambda表达式简化-"+str2);

		//todo 获取数组中最大值
		int[] arr = {1,2,3333,5,2,6665,67644,677,7,5,43,4,2,3};
		int max = getMax(()->{
			int rtn = arr[0];
			for (int i:arr){
				if (i>rtn){
					rtn = i;
				}
			}
			return rtn;
		});
		System.out.println("Supplier数组最大值"+max);

	}

	private static int getMax(Supplier<Integer> supplier) {
		return supplier.get();
	}
}

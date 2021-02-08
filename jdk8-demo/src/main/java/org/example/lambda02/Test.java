package org.example.lambda02;

import java.util.Comparator;
import java.util.TreeSet;

public class Test {

	private static Comparator<Integer> comparator(){
		return new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1,o2);
			}
		};
	}
	private static Comparator<Integer> comparator1(){
		return (Integer o1,Integer o2)->o2.compareTo(o1);
	}

	public static void main(String[] args) {
		//todo 匿名内部类
		Comparator<Integer> cbt = comparator();

		TreeSet<Integer> treeSet = new TreeSet<>(cbt);
		treeSet.add(1);
		treeSet.add(3);
		treeSet.add(2);
		treeSet.add(100);
		System.out.println(treeSet);
		System.out.println("================================");

		//todo 使用lambda表达式
		Comparator<Integer> cbt1 = comparator1();
		TreeSet<Integer> treeSet1 = new TreeSet<>(cbt1);
		treeSet1.add(1);
		treeSet1.add(3);
		treeSet1.add(2);
		treeSet1.add(100);
		System.out.println(treeSet1);

		//类型检查、类型推断
		//todo 无类型推断
		Comparator<Integer> cbt3 =(Integer o1,Integer o2)->o2.compareTo(o1);
		//todo 有类型推断
		Comparator<Integer> cbt4 =(o1,o2)->o2.compareTo(o1);
	}
}

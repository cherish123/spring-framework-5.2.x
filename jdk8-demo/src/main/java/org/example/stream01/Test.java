package org.example.stream01;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("浮小麦");
		list.add("胡黄连");
		list.add("银柴胡");
		list.add("青嵩");
		for (String medecine:list){
			if (medecine.startsWith("青")&&medecine.length()==2){
				System.out.println("抓药"+medecine);
			}
		}

		//todo stream流式处理
		list.stream().filter(medecine->medecine.startsWith("青")).filter(medecine->medecine.length()==2).forEach(medecine-> System.out.println("抓药"+medecine));
	}
}
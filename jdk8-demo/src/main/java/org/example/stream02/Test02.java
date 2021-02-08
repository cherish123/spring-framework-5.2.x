package org.example.stream02;

import java.util.*;
import java.util.stream.Stream;

public class Test02 {
	public static void main(String[] args) {
		//todo list获取流
		List<String> list = new ArrayList<>();
		Stream<String> listStream = list.stream();
		//todo set获取流
		Set<Integer> set = new HashSet<>();
		Stream<Integer> setStream = set.stream();
		//todo map获取流
		Map<String,Integer> map = new HashMap<>();
		Set<String> mapKeys = map.keySet();
		Stream<String> mapKeysStream = mapKeys.stream();
		Collection<Integer> mapValues = map.values();
		Stream<Integer> valueStreams = mapValues.stream();

		//todo 数组获取流
		Stream<Integer> integerStream = Stream.of(1, 2, 5, 6, 9, 8, 3);
		String[] arr = {"金银花","薄荷","滑石粉"};
		Stream<String> arrStream = Stream.of(arr);
	}

}

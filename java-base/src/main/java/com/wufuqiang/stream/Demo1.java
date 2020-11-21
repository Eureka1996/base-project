package com.wufuqiang.stream;

import java.util.Arrays;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("fuqi","wu","fu","qiang","f1","f2");
		list.stream()
				.filter((item) -> item.startsWith("f"))
				.limit(2)
				.forEach(System.out::println);
	}
}

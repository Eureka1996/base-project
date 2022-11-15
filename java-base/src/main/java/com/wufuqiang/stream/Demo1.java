package com.wufuqiang.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("fuqi","wu","fu","qiang","f1","f2");
		list.stream()
				.filter((item) -> item.startsWith("f"))
				.limit(2)
				.forEach(System.out::println); //方法构造

		list.stream()
				.map(String::toUpperCase)
				.forEach(System.out::println);
		System.out.println("-----------------");

		Stream<char[]> stream = list.stream()
				.flatMap((item) -> Stream.of(item.toCharArray()));

//				.forEach(System.out::println);

		System.out.println("----------");
		Stream.of("f","u").forEach(System.out::println);

		System.out.println("-----------------------------");
		list.stream().sorted((i1,i2) -> Integer.compare(i1.length(),i2.length())).forEach(System.out::println);

		System.out.println("----------------------------");
		String myj = list.stream().reduce("myj", (i1, i2) -> i1 + " " + i2);
		System.out.println(myj);


		Optional<String> reduce = list.stream().reduce((i1, i2) -> i1 + "\t" + i2);
		System.out.println(reduce.orElse("maoyujiao"));


		List<String> collect = list.stream().filter((item) -> item.length() > 3).collect(Collectors.toList());
		collect.forEach(System.out::println);

		Map<Integer, Map<Character, List<String>>> collect1 = list.stream().
				collect(Collectors.groupingBy(
						    (item) -> item.length(),
						    Collectors.groupingBy((item) -> item.charAt(0))));
		collect1.forEach((key,value)->System.out.println(key+"="+value));


		List<Integer> numList = Arrays.asList(1,2,3,4,5);

		numList.stream().map(Math::sqrt).forEach(System.out::println);

	}
}

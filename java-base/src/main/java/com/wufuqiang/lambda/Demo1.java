package com.wufuqiang.lambda;



import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * java8接口新特性
 */
public class Demo1 {

	@Test
	public void test1(){
		Comparator<String> c1 = Comparator.naturalOrder();
		Comparator<String> c2 = c1.reversed();
		List<String> list = Arrays.asList("wu","fu","qiang");
		System.out.println("wufq");
		list.forEach(item -> System.out.println(item));
	}

}

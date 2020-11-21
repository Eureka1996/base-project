package com.wufuqiang.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Demo3 {

	@Test
	public void test1(){
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1,o2);
			}
		};

		Comparator<Integer> c2 = (x,y) -> Integer.compare(x,y);

		Collections.sort(Arrays.asList(""),(x,y)->x.compareTo(y));

		test2(Arrays.asList("wu","fu","qiang"),(x)->x.substring(0,1));

	}

	public void test2(List<String> list, Function<String,String> func){
		for(String s : list){
			String ap = func.apply(s);
			System.out.println(ap);
		}
	}
}

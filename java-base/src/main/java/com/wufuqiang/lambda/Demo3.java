package com.wufuqiang.lambda;

import java.util.Comparator;

public class Demo3 {

	public void test1(){
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1,o2);
			}
		};

		Comparator<Integer> c2 = (x,y) -> Integer.compare(x,y);
	}
}

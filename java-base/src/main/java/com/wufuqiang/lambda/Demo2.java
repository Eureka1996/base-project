package com.wufuqiang.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2 {

	@Test
	public void test1(){
		List<String> list = Arrays.asList("wu","fu","wiang");
		List<String> res = filterNames(list, new Filter() {
			@Override
			public boolean filter(String name) {
				return name.startsWith("w");
			}
		});
		System.out.println(res);

		list.forEach(item -> item.startsWith("f"));

		List<String> f = filterNames(list, (item) -> item.startsWith("f"));


		System.out.println(f);
	}

	//过滤出符合条件的字符串
	public List<String> filterNames(List<String> names,Filter filter){
		List<String> newName = new ArrayList<>();
		for(String n : names){
			if(filter.filter(n)) newName.add(n);
		}
		return newName;
	}
}

interface Filter{
	boolean filter(String name);
}

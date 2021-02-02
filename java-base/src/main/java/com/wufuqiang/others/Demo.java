package com.wufuqiang.others;

import org.junit.jupiter.api.Test;

public class Demo {

	@Test
	public void test1(){


		String str = "76.00%\n" +
				"76.57%\n" +
				"75.82%\n" +
				"75.00%\n" +
				"74.81%\n" +
				"75.10%\n" +
				"73.56%\n" +
				"74.57%\n" +
				"74.82%\n" +
				"73.94%\n" +
				"73.25%\n" +
				"74.23%\n" +
				"74.12%\n" +
				"73.99%\n" +
				"74.84%\n" +
				"74.61%\n" +
				"73.97%\n" +
				"74.76%\n" +
				"75.19%\n" +
				"74.47%\n" +
				"75.01%\n" +
				"74.96%\n" +
				"#DIV/0!\n" +
				"74.72%\n" +
				"74.67%\n" +
				"74.61%\n" +
				"74.10%\n" +
				"74.66%\n" +
				"74.39%\n" +
				"74.03%";
		String[] split = str.split("\n");
		for(int i = split.length-1;i>=0;i--){
			System.out.println(split[i]);
		}
	}
}

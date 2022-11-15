package com.wufuqiang.dateformat;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo1 {

	public int test3(){
		int [] arr = new int[10];
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i< arr.length;i++){
			map.put(arr[i],i);
		}
		int num = 8;
		int res = map.getOrDefault(8, -1);
		return res;
	}

	//
	public void test2(){
		int [] arr = new int[10];
		Arrays.sort(arr);
		int resValue =  7;
		int left = 0;
		int right = arr.length-1;
		int value  = arr[left] = arr[right];
		while(value != resValue){
			if(value > resValue){
				 right --;
			}else{
				left ++;
			}
			value = arr[left] = arr[right];
		}
		System.out.println(arr[left]+","+arr[right]);
	}

	@Test
	public void test1(){
		DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
		isoDateTime.withZone(ZoneId.systemDefault());
		System.out.println(ZoneId.systemDefault());
		LocalDateTime now = LocalDateTime.now();
		String format = now.format(isoDateTime);
		System.out.println(format);

//		TemporalAccessor parse = isoDateTime.parse("2016-08-15T16:00:00.000Z");
//		System.out.println(parse);

		LocalDateTime parse = LocalDateTime.parse("2016-08-15T16:24:00.000Z",DateTimeFormatter.ISO_ZONED_DATE_TIME);
		ZonedDateTime parse1 = ZonedDateTime.parse("2016-08-15T16:24:00.000Z", DateTimeFormatter.ISO_ZONED_DATE_TIME);
//		LocalDateTime.
		String format1 = parse.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS"));
		String format2 = parse1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS").withZone(ZoneId.systemDefault()));

		System.out.println(format1);
		System.out.println(parse1);
		System.out.println(format2);
	}
}

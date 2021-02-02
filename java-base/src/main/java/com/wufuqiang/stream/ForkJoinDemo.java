package com.wufuqiang.stream;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinDemo {

	@Test
	public void test1(){
		Instant start = Instant.now();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new MyForkJoinTask(0,1000000000000L);
		Long sum = pool.invoke(task);
		Instant end = Instant.now();
		System.out.println(sum);
		System.out.println("耗时时间为："+ Duration.between(start,end).toMillis()+"ms");
		test2();
	}
	@Test
	public void test2(){
		Instant start = Instant.now();
		long sum = 0;
		for(long i = 0;i<1000000000000L;i++){
			sum+=i;
		}
		Instant end = Instant.now();
		System.out.println(sum);
		System.out.println("耗时时间为："+Duration.between(start,end).toMillis()+"ms");

	}

	@Test
	public void test3(){
		long sum = LongStream.range(0, 1000000000000L).parallel().reduce(0, Long::sum);
		System.out.println(sum);
	}
}

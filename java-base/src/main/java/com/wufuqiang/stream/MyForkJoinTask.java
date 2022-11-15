package com.wufuqiang.stream;

import java.util.concurrent.RecursiveTask;

public class MyForkJoinTask extends RecursiveTask<Long> {

	private long start;
	private long end;
	private static final long THRESHOLD = 10000;

	public MyForkJoinTask(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long length = end - start ;
		if(length <= THRESHOLD){
			long sum = 0;
			for(long i = start;i<end;i++){
				sum+=i;
			}
			return sum;
		}else{
			long middle = (start+end)/2;
			MyForkJoinTask left = new MyForkJoinTask(start,middle);
			left.fork();//拆分子任务，同时压入线程队列
			MyForkJoinTask right = new MyForkJoinTask(middle+1,end);
			right.fork();

			return left.join()+right.join();

		}
	}
}

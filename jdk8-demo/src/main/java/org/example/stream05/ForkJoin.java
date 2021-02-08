package org.example.stream05;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoin extends RecursiveTask<Long> {
	/**
	 * 要想使用Fork-Join,类必须继承RecursiveAction（无返回值）或者RecursiveTask(有返回值)
	 */
	private long start;
	private long end;

	public ForkJoin() {
	}

	@Override
	protected Long compute() {
		if (end-start <= THRESHOLD){
			long sum = 0;
			for (long i = start;i<end;i++){
				sum+=i;
			}
			return sum;
		} else {
			long middle = (end-start)/2;
			ForkJoin left = new ForkJoin(start,middle);
			//todo 拆分子任务，压入线程队列
			left.fork();
			ForkJoin right = new ForkJoin(middle+1,end);
			right.fork();

			//todo 合并并返回
			return left.join()+right.join();

		}
	}

	public ForkJoin(long start, long end) {
		this.start = start;
		this.end = end;
	}

	//todo 定义阙值
	private static final long THRESHOLD = 10000L;

	public void test01(){
		//todo 开始时间
		Instant start = Instant.now();

		//todo 这里需要一个线程池的支持
		ForkJoinPool forkJoinPool = new ForkJoinPool();

		ForkJoinTask<Long> task = new ForkJoin(0L,10000000000L);
		//todo 没有返回值  forkJoinPool.execute
		// 有返回值
		forkJoinPool.invoke(task);

		//todo 结束时间
		Instant end = Instant.now();
		System.out.println(Duration.between(start,end).getSeconds());
	}

	public void test02(){
		//todo 开始时间
		Instant start = Instant.now();

		//todo 并行流计算   累加求和
		LongStream.rangeClosed(0,10000000000L).parallel().reduce(0,Long::sum);

		//todo 结束时间
		Instant end = Instant.now();
		System.out.println(Duration.between(start,end).getSeconds());
	}

	public void test03() {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		//单线程串行打印
		integers.stream().forEach(System.out::print);
		//多线程并行打印
		integers.parallelStream().forEach(System.out::print);
	}

	public void test04(){
		//todo 并行流 多个线程执行
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		integers.parallelStream().forEach(System.out::print);
		System.out.println("=======================================");
		//串行
		integers.stream().sequential().forEach(System.out::print);
	}
}

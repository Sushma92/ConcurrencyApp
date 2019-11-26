package sushma.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Callable<String> firstTenNumbers = () -> {

			for (int aNum = 1; aNum <= 10; aNum++) {
				System.out.println("t1" + " " + aNum + " ");
			}
			return "first 10 numbers";

		};

		Callable<String> firstTwentyNumbers = () -> {
			for (int aNum = 1; aNum <= 20; aNum++) {
				System.out.println("t2" + " " + aNum + " ");
			}
			return "first 20 numbers";
		};

		Callable<String> firstThirtyNumbers = () -> {
			for (int aNum = 1; aNum <= 30; aNum++) {
				System.out.println("t3" + " " + aNum + " ");
			}
			return "first 30 numbers";
		};

		List<Callable<String>> callableList = new ArrayList<>();

		callableList.add(firstTenNumbers);
		callableList.add(firstTwentyNumbers);
		callableList.add(firstThirtyNumbers);

		List<Future<String>> futureList = executorService.invokeAll(callableList);

		for (Future<String> aFuture : futureList) {
			System.out.println(aFuture.get());
		}

		executorService.shutdown();
	}

}

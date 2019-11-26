package sushma.java.concurrency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllExample2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Callable<Object> intCallable = () -> {
			return 20;
		};

		Callable<Object> stringCallable = () -> {
			return "This is callable 2";
		};

		Callable<Object> dateCallable = () -> {
			return new Date();
		};

		List<Callable<Object>> callableList = new ArrayList<>();

		callableList.add(intCallable);
		callableList.add(stringCallable);
		callableList.add(dateCallable);

		List<Future<Object>> futureList = executorService.invokeAll(callableList);

		for (Future<Object> aFuture : futureList) {
			System.out.println(aFuture.get());
		}

		executorService.shutdown();

	}

}

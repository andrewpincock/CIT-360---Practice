package net.codyconder.threads.practice;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SillyThreadPoolExample {

	public static void main(String[] args) {
		Executor anExecutor = Executors.newCachedThreadPool();
		for(int threadCnt = 0; threadCnt < 3; threadCnt++) {
			SimpleRunnableExample aSimpleRunnable = new SimpleRunnableExample();
			anExecutor.execute(aSimpleRunnable);
		}
		try {
			Thread.sleep(5000);
			System.out.println("Done sleeping");
			for(int threadCnt = 0; threadCnt < 3; threadCnt++) {
				SimpleRunnableExample aSimpleRunnable = new SimpleRunnableExample();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

package net.codyconder.threads.practice;

public class SimpleRunnableStarter {

	public static void main(String[] args) {
		for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
			SimpleRunnableExample aSimpleRunnable = new SimpleRunnableExample();
			Thread aThread = new Thread(aSimpleRunnable);
			aThread.start();
		}

	}

}

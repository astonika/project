package com.example.demo.api;

public class TestMq {
	public static void main(String[] args) {
		Producter producter = new Producter();
		Consumer consumer = new Consumer();
		producter.init();
		consumer.init();
		TestMq testMq = new TestMq();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		// Thread 1
//		new Thread(testMq.new ProducterMq(producter)).start();
//		// Thread 2
//		new Thread(testMq.new ProducterMq(producter)).start();
//		// Thread 3
//		new Thread(testMq.new ProducterMq(producter)).start();
//		// Thread 4
//		new Thread(testMq.new ProducterMq(producter)).start();
//		// Thread 5
//		new Thread(testMq.new ProducterMq(producter)).start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Thread 6
		new Thread(testMq.new ConsumerMq(consumer)).start();
		// Thread 7
		new Thread(testMq.new ConsumerMq(consumer)).start();
		// Thread 8
		new Thread(testMq.new ConsumerMq(consumer)).start();
		// Thread 9
		new Thread(testMq.new ConsumerMq(consumer)).start();
		// Thread 10
		new Thread(testMq.new ConsumerMq(consumer)).start();
	}

	private class ProducterMq implements Runnable {
		Producter producter;

		public ProducterMq(Producter producter) {
			this.producter = producter;
		}

		@Override
		public void run() {
			while (true) {
				try {
					producter.sendMessage("Astonika-MQ");
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class ConsumerMq implements Runnable {
		Consumer consumer;

		public ConsumerMq(Consumer consumer) {
			this.consumer = consumer;
		}

		@Override
		public void run() {
			while (true) {
				try {
					consumer.getMessage("Astonika-MQ");
					Thread.sleep(10000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}

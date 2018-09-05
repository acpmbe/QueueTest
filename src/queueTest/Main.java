package queueTest;

import java.util.*;
import java.util.concurrent.*;

public class Main
{

	public static void main(String[] args)
	{

		final Basket basket = new Basket();

		// 定义苹果生产者
		class Producer implements Runnable
		{
			public void run()
			{
				try
				{
					for (int i = 0; i < 6; i++)
					{
						// 生产苹果
						System.out.println("生产者准备生产苹果：" + System.currentTimeMillis());
						basket.produce();
						System.out.println("生产者生产苹果完毕：" + System.currentTimeMillis());
						System.out.println("生产完后有苹果：" + basket.getAppleNumber() + "个");
						// 休眠300ms
						Thread.sleep(300);

					}

					// Thread.sleep(30 * 1000);
					//
					// for (int i = 0; i < 10; i++)
					// {
					// // 生产苹果
					// System.out.println("生产者准备生产苹果：" + System.currentTimeMillis());
					// basket.produce();
					// System.out.println("生产者生产苹果完毕：" + System.currentTimeMillis());
					// System.out.println("生产完后有苹果：" + basket.getAppleNumber() + "个");
					// // 休眠300ms
					// Thread.sleep(300);
					//
					// }
				}
				catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
			}
		}

		class Producerdd implements Runnable
		{
			public void run()
			{
				try
				{
					while (true)
					{
						// 消费苹果
						System.out.println("消费者准备消费苹果：" + System.currentTimeMillis());
						System.out.println(basket.consume().get(0));

						System.out.println("消费者消费苹果完毕：" + System.currentTimeMillis());
						System.out.println("消费完后有苹果：" + basket.getAppleNumber() + "个");
						// 休眠1000ms
						Thread.sleep(1000);
					}
				}
				catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
			}
		}

		ExecutorService service = Executors.newCachedThreadPool();

		Producer cProducer = new Producer();
		Producerdd cs = new Producerdd();

		service.submit(cProducer);

		try
		{
			Thread.sleep(10 * 1000);
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}

		service.submit(cs);

	}

}

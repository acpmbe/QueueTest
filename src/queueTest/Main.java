package queueTest;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

import test_1.*;
import test_1.Stack;
import test_3.Get_Redis;
import test_3.Handle_Redis;
import test_3.Stack_Redis;

public class Main
{

	static void Run1()
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

	static void Test_3()
	{
		Stack stack = new Stack();
		MThreadPop pop = new MThreadPop(stack);
		MThreadPush push = new MThreadPush(stack);
		pop.setRun(true);
		push.setRun(true);
		// sysPrint(stack);
		// 向栈中循环添加数据
		push.start();
		// sysPrint(stack);
		// 打印所有的栈的数据
		pop.start();
		// sysPrint(stack);
		// ExecutorService service = Executors.newCachedThreadPool();
		// service.submit(push);
		// service.submit(pop);
		try
		{
			sysPrint(stack);
			Thread.sleep(10000);
			// service.shutdownNow();

			sysPrint(stack);

			// push.setRun(false);
			// pop.setRun(false);

			// service.shutdown();
			Thread.sleep(1000 * 2);
		}
		catch (InterruptedException e)
		{
			System.out.println("-------InterruptedException------------>end");
			e.printStackTrace();
		}
		System.out.println("------------------->end");
	}

	private static void sysPrint(Stack stack)
	{
		System.out.println(stack.toString());
	}

	public static void main(String[] args)
	{

		Stack_Redis stack = new Stack_Redis(10);

		Thread Get_Redis = new Thread(new Get_Redis(stack));
		Get_Redis.start();

		try
		{
			Thread.sleep(5 * 1000);
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}

		// Thread Handle_Redis = new Thread(new Handle_Redis(stack));
		// Handle_Redis.start();

		Thread Handle_Redis;

		for (int i = 0; i < 10; i++)
		{
			Handle_Redis = new Thread(new Handle_Redis(stack));

			Handle_Redis.start();

		}

	}

}

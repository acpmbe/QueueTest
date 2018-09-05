package queueTest;

import java.util.*;

import java.util.concurrent.*;

public class Basket
{
	// LinkedBlockingDeque<String> basket = new LinkedBlockingDeque<String>(6);

	LinkedBlockingDeque<List<String>> basket = new LinkedBlockingDeque<List<String>>(6);

	int count;

	// 篮子，能够容纳3个苹果
	// BlockingQueue<String> basket = new ArrayBlockingQueue<String>(5);

	// 生产苹果，放入篮子
	public void produce() throws InterruptedException
	{
		// put方法放入一个苹果，若basket满了，等到basket有位置

		count++;
		// basket.put("An apple");

		List<String> list_Add = new ArrayList<String>();
		list_Add.add(String.valueOf(count));

		basket.put(list_Add);
	}

	// 消费苹果，从篮子中取走
	public List<String> consume() throws InterruptedException
	{
		// get方法取出一个苹果，若basket为空，等到basket有苹果为止
		return basket.take();

	}

	public int getAppleNumber()
	{
		return basket.size();
	}

}

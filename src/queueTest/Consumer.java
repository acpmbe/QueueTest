package queueTest;

public class Consumer implements Runnable
{

	@Override
	public void run()
	{

		try
		{
			Basket basket= new  Basket();
			
			while (true)
			{
				// 消费苹果
				System.out.println("消费者准备消费苹果：" + System.currentTimeMillis());
				basket.consume();
				
		
				System.out.println("消费者消费苹果完毕：" + System.currentTimeMillis());
				System.out.println("消费完后有苹果：" + basket.getAppleNumber() + "个");
				// 休眠1000ms
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException ex)
		{
		}

	}

}

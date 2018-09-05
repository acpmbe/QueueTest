package test_3;

import javax.swing.plaf.basic.BasicLabelUI;

public class Handle_Redis implements Runnable
{

	private Stack_Redis Stack;

	public Handle_Redis(Stack_Redis stack)
	{
		this.Stack = stack;
	}

	private Long StartTime;
	private Long EndTime;

	private boolean IsRun;

	@Override
	public void run()
	{

		IsRun = true;
		StartTime = System.currentTimeMillis();

		while (IsRun)
		{
			this.Handle();

		}

		EndTime = System.currentTimeMillis();

		System.out.println("线程" + Thread.currentThread().getName() + " 消费执行时间是：" + (EndTime - StartTime) + "ms");

	}

	private void Handle()
	{

		try
		{
			// currentThread().getName()

			System.out.println("消费者准备取数据：" + System.currentTimeMillis());

			if (Stack.getSize() == 0)
			{

				IsRun = false;
				return;

			}

			Thread.sleep(3 * 1000);

			String content = this.Stack.Pop();
			System.out.println("线程" + Thread.currentThread().getName() + " 消费者数据是：" + content);

			System.out.println("消费者取数据完毕：" + System.currentTimeMillis());

			System.out.println("消费者取完数据后：" + Stack.getSize() + "条数据");

		}
		catch (InterruptedException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}

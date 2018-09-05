package test_3;

public class Handle_Redis implements Runnable
{

	private Stack_Redis Stack;

	public Handle_Redis(Stack_Redis stack)
	{
		this.Stack = stack;
	}
	


	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(1*1000);
				this.Handle();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

	}

	private void Handle()
	{

		try
		{

			System.out.println("消费者 = 准备从仓库取数据：" + System.currentTimeMillis());

			String content = this.Stack.Pop();
			System.out.println("消费者 = 取过来的数据是：" + content);

			System.out.println("消费者 = 从仓库取数据完毕：" + System.currentTimeMillis());
			System.out.println("消费者 = 从仓库取完数据后还有：" + Stack.getSize() + "条数据");

		}
		catch (InterruptedException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}

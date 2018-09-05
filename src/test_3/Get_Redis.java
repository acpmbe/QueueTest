package test_3;

public class Get_Redis implements Runnable
{

	private Stack_Redis Stack;

	private int Num;

	public Get_Redis(Stack_Redis stack)
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
				Thread.sleep(5*1000);
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
			Num++;
			System.out.println("生产者 = 开始取Redis数据放入仓库：" + System.currentTimeMillis());

			this.Stack.Push(String.valueOf(Num));

			System.out.println("生产者 = 取Redis数据放入仓库完毕：" + System.currentTimeMillis());
			System.out.println("生产者 = 取Redis数据后仓库有：" + Stack.getSize() + "条数据");

		}
		catch (InterruptedException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}

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
		try
		{
			for (int i = 0; i < 6; i++)
			{
				// Thread.sleep(1 * 1000);
				this.Handle();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	private void Handle()
	{

		try
		{

			Num++;
			System.out.println("生产者开始放入仓库：" + System.currentTimeMillis());

			this.Stack.Push(String.valueOf(Num));

			System.out.println("生产者放入仓库完毕：" + System.currentTimeMillis());
			System.out.println("生产完后：" + Stack.getSize() + "条数据");

		}
		catch (InterruptedException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}

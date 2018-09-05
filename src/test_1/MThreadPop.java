package test_1;

public class MThreadPop extends Thread
{

	/**
	 * 需要执行的数据的引用
	 */
	private Stack stack;

	/**
	 * 表示运行的字段
	 */
	private boolean isRun;

	public MThreadPop(Stack stack)
	{
		super();
		this.stack = stack;
	}

	@Override
	public void run()
	{
		super.run();
		while (this.isRun)
		{
			try
			{
				Thread.sleep(1000);
				this.operation();
			}
			catch (InterruptedException e)
			{
				// e.printStackTrace();
			}
		}
	}

	protected void operation() throws InterruptedException
	{
		String str = null;
		try
		{
			str = this.stack.Pop();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("--------------------->取出" + str);
	}

	@Override
	public synchronized void start()
	{
		super.start();

	}

	public boolean isRun()
	{
		return isRun;
	}

	public void setRun(boolean run)
	{
		isRun = run;
	}

	public Stack getStack()
	{
		return stack;
	}

}

package test_1;

public class MThreadPush extends Thread
{

	/**
	 * 需要执行的数据的引用
	 */
	private Stack stack;

	/**
	 * 表示运行的字段
	 */
	private boolean isRun;

	private int i;

	public MThreadPush(Stack stack)
	{
		super();
		this.stack = stack;
		i = 0;
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
		System.out.println("--------------------->放入" + i);
		this.getStack().Push(String.valueOf(i++));
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

package test_3;

import java.util.concurrent.LinkedBlockingDeque;

public class Stack_Redis
{

	/**
	 * 用于保存数据的仓库
	 */
	private LinkedBlockingDeque<String> stringList;

	public Stack_Redis(int maxSize)
	{
		this.stringList = new LinkedBlockingDeque<String>(maxSize);

	}

	/**
	 * 向栈中添加数据
	 * 
	 * @param str
	 *            栈中需要添加的数据
	 * @throws InterruptedException
	 */
	public void Push(String str) throws InterruptedException
	{
		stringList.put(str);
	}

	/**
	 * 获取栈中的数据，如果没有数据就返回null
	 * 
	 * @return 返回的栈的最顶端的数据
	 * @throws InterruptedException
	 */
	public String Pop() throws InterruptedException
	{
		return this.stringList.take();
	}
	
	public int getSize()
	{
		return stringList.size();
	}
}

package test_1;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * java模拟的栈类
 * 
 */
public class Stack
{

	/**
	 * 用于保存数据的仓库
	 */
	private LinkedBlockingDeque<String> stringList;

	public Stack()
	{
		this.stringList = new LinkedBlockingDeque<String>(5);

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

	@Override
	public String toString()
	{
		return "Stack{" + "stringList=" + stringList + '}';
	}

}

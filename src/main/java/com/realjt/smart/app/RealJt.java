/**
 * RealJt.java
 */
package com.realjt.smart.app;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * @author RealJt
 * @date 2018年6月27日
 */
public class RealJt
{
	
	
//	 private static List<String> list = new ArrayList<String>();

	private static List<String> list = new CopyOnWriteArrayList<String>();

	public static void main(String[] args)
	{
		// 同时启动两个线程对list进行操作！
		new ThreadOne().start();
		new ThreadTwo().start();
		while (true)
		{
			System.out.println("abc");
		}
	}

	private static void printAll(String name)
	{
		String value = null;
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
		{
			value = (String) iter.next();
			System.out.println(value + "-" + name + ", ");
		}
	}

	/**
	 * 向list中依次添加0,1,2,3,4,5，每添加一个数之后，就通过printAll()遍历整个list
	 */
	private static class ThreadOne extends Thread
	{
		@Override
		public void run()
		{
			int i = 0;
			while (i < 6)
			{
				list.add(String.valueOf(i));
				printAll(getName());
				i++;
			}
		}
	}

	/**
	 * 向list中依次添加10,11,12,13,14,15，每添加一个数之后，就通过printAll()遍历整个list
	 */
	private static class ThreadTwo extends Thread
	{
		@Override
		public void run()
		{
			int i = 10;
			while (i < 16)
			{
				list.add(String.valueOf(i));
				printAll(getName());
				i++;
			}
		}
	}
}

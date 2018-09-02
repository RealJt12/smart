package com.realjt.smart.app;

/**
 * 
 * 
 * @author RealJt
 * @date 2018年6月27日
 */
public class A extends RealJt
{
	{
	}
	
	static{
		System.out.println("aaaaaaaaaaaaaaaaaaaa");
	}

	public final int a;

	public A()
	{
		a = 30;
	}

	public int getA()
	{
		return a;
	}

	@Override
	public void finalize() throws Throwable
	{
		super.finalize();
	}

}

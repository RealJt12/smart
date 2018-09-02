/**
 * E.java
 */
package com.realjt.smart.app;

/**
 * 
 * @author RealJt
 * @date 2018年7月10日
 */
public class E
{
	public static void main(String[] args)
	{
		System.out.println(E.class.getClassLoader().getParent().getParent());

		int i = 10;

		i = i++;
		System.out.println(i);
	}

}

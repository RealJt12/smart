/**
 * F.java
 */
package com.realjt.smart.app;

/**
 * 
 * @author RealJt
 * @date 2018年9月1日
 */
public class F
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 2005; i++)
		{
			for (int j = 0; j < 2005; j++)
			{
				if ((i * i + 1) * (j * j + 1) == 2005)
				{
					System.out.println(i + " " + j);
				}
			}
		}
	}

}

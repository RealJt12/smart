/**
 * D.java
 */
package com.realjt.smart.app;

/**
 * 
 * @author RealJt
 * @date 2018年7月6日
 */
public class D
{
	public static void main(String[] args)
	{
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);

		int a = -6;
		for (int i = 0; i < 32; i++)
		{
			int t = (a & 0x80000000 >>> i) >>> (31 - i);
			System.out.print(t);
		}

		System.out.println();
		
		float f = 100.2f;
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));
		
		System.out.println();
	}

}

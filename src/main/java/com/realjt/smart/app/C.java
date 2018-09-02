/**
 * C.java
 */
package com.realjt.smart.app;

/**
 * 
 * @author RealJt
 * @date 2018年7月5日
 */
public class C
{
	public static void main(String[] args)
	{
		int i = 5;
		i |= i >>> 1;
		i |= i >>> 2;
        i |= i >>> 4;
        i |= i >>> 8;
        i |= i >>> 16;
		System.out.println(i);
		
		System.out.println(new C().hashCode());
	}
}

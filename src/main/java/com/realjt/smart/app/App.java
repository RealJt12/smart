package com.realjt.smart.app;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * 
 * @author RealJt
 * @date 2018年6月27日
 */
public class App
{
	static{
		System.out.println("App");
	}
	
	public static void main(String[] args) throws ClassNotFoundException
	{
		byte b = 10;
		System.out.println(b);
		System.out.println("abc");

		System.out.println(0x11);
		System.out.println('a' << 1);

		System.out.println(1 << 30);
		System.out.println(-2 ^ 3);
		System.out.println(-31 >> 2);
		System.out.println(~-8);

		System.out.println(Integer.MAX_VALUE);
		int x = -2147483647;
		int y = -2147483646;

		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println(x);
		System.out.println(y);

		int i = -100;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toHexString(i));

		short s = 5;
		s += 5;
		System.out.println(s);

		System.out.println((char) ('a' - 32));
		System.out.println((int) 'A');

		System.out.println(Math.sqrt(121));

		int[][] ds = new int[3][];
		System.out.println(ds.length);

		A aa = new A();
		System.out.println(aa.getA());

		System.out.println(new Integer(1000) == 1000);
		System.out.println(new Integer(10).equals(new Integer(10)));

		List<Integer> list = new ArrayList<>();
		list.add(123);
		list.add(456);

		List<Integer> list1 = Arrays.asList(new Integer[list.size()]);

		Collections.copy(list1, list);
		System.out.println(list1);

		System.out.println(Boolean.parseBoolean("true"));

		System.out.println(new StringBuffer().capacity());
		System.out.println(new StringBuilder().capacity());

		try
		{
			InetAddress inetAddress = InetAddress.getLocalHost();
			System.out.println(inetAddress);
			System.out.println(inetAddress.getHostName());
			System.out.println(inetAddress.getHostAddress());
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
	}

}

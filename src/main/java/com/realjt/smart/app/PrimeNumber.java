package com.realjt.smart.app;

/**
 * 判断质数的方法
 *
 * @author RealJt
 * @date 2018年6月17日
 */
public class PrimeNumber
{
	private static final int INT_2 = 2;

	private static final int INT_3 = 3;

	private static final int INT_5 = 5;

	private static final int INT_6 = 6;

	/**
	 * 普通判断方法,在大于1的自然数中,除了1和它本身以外不再有其他因数
	 * 
	 * @time 时间复杂度O(n)
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPrimeNumberNormal(int number)
	{
		if (number <= 1)
		{
			return false;
		}

		if (INT_2 == number || INT_3 == number || INT_5 == number)
		{
			return true;
		}

		for (int i = 2; i < number; i++)
		{
			if (number % i == 0)
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * 优化后的方法,一个整数能被两个因数分解,那么其中一个因数一定小于等于该数开平方根数,另一个因数一定大于等于该数开平方根数,并且去掉偶数的判断
	 * 
	 * @time 时间复杂度O(sqrt(n)/2)
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPrimeNumberOptimize(int number)
	{
		if (number <= 1)
		{
			return false;
		}

		if (INT_2 == number || INT_3 == number || INT_5 == number)
		{
			return true;
		}

		if (number % INT_2 == 0)
		{
			return false;
		}

		double squareRoot = Math.sqrt(number);
		for (int i = 3; i <= squareRoot; i += INT_2)
		{
			if (number % i == 0)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * 优化后更快的方法
	 * 
	 * 自然数可以表示为6x,6x+1,6x+2,6x+3,6x+4,6x+5,其中x为大于等于0的整数
	 * 由于6x=2(3x),6x+2=2(3x+1),6x+3=3(2x+1),6x+4=2(3x+2),故这四类数不可能为质数
	 * 那么剩下6x+1和6x+5两类整数才可能是质数,即在6的倍数相邻两侧的整数才可能是质数,但在6的倍数相邻两侧的整数并不是一定就是质数,例如25
	 * 
	 * 假设要被判断的数为number=6x+1或6x+5,循环判断比numnber更小的数
	 * 小于sqrt(n)需要判断是否能被整除的数可分为6i,6i+1,6i+2,6i+3,6i+4,6i+5六类
	 * 
	 * 如果number能被6i,6i+2,6i+4整除,则number得是一个偶数,显然number=6x+1或6x+5不可能是偶数,故不用判断number是否能被这三类数整除
	 * 如果number能被6i+3整除,则number至少能被3整除,但是6x能被3整除,number=6x+1或6x+5不可能被3整除,故不用判断number是否能被6i+3整除
	 * 剩下只需要判断number是否能被6i+1和6i+5整除,即5和7,11和13,设置步长为6
	 * 
	 * @time 时间复杂度O(sqrt(n)/3)
	 * 
	 * @param number
	 * @return 是否是质数
	 */
	public static boolean isPrimeNumberFast(int number)
	{
		if (number <= 1)
		{
			return false;
		}

		if (INT_2 == number || INT_3 == number || INT_5 == number)
		{
			return true;
		}

		// 不在6的倍数两侧的一定不是质数
		if (number % INT_6 != 1 && number % INT_6 != INT_5)
		{
			return false;
		}

		// 在6的倍数两侧的也可能不是质数
		double squareRoot = Math.sqrt(number);
		for (int i = INT_5; i <= squareRoot; i += INT_6)
		{
			if (number % i == 0 || number % (i + 2) == 0)
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		int range = 500000;
		int total = 0;

		long startTime = System.currentTimeMillis();
		for (int i = 1; i <= range; i++)
		{
			if (isPrimeNumberNormal(i))
			{
				System.out.println(i);
				total++;
			}
		}
		System.out.println("time: " + (System.currentTimeMillis() - startTime) + " total: " + total);

		total = 0;
		startTime = System.currentTimeMillis();
		for (int i = 1; i <= range; i++)
		{
			if (isPrimeNumberOptimize(i))
			{
				System.out.println(i);
				total++;
			}
		}
		System.out.println("time: " + (System.currentTimeMillis() - startTime) + " total: " + total);

		total = 0;
		startTime = System.currentTimeMillis();
		for (int i = 1; i <= range; i++)
		{
			if (isPrimeNumberFast(i))
			{
				System.out.println(i);
				total++;
			}
		}
		System.out.println("time: " + (System.currentTimeMillis() - startTime) + " total: " + total);
	}

}

/**
 * ShellSort.java
 */
package com.realjt.smart.app;

/**
 * Shell排序
 * 
 * @author RealJt
 * @date 2018年7月15日
 */
public class ShellSort
{
	public static void shellSort(int[] data)
	{
		System.out.println("开始排序");
		int arrayLength = data.length;

		int h = 1;
		while (h <= arrayLength / 3)
		{
			h = h * 3 + 1;
		}
		while (h > 0)
		{
			System.out.println("===h的值：" + h + "===");
			for (int i = h; i < arrayLength; i++)
			{
				int temp = data[i];
				if (data[i] < data[i - h])
				{
					int j = i - h;
					for (; j >= 0 && data[j] > temp; j -= h)
					{
						data[j + h] = data[j];
					}
					data[j + h] = temp;
				}
				System.out.println(java.util.Arrays.toString(data));
			}
			h = (h - 1) / 3;
		}
	}

	public static void main(String[] args)
	{
		int[] data = { 9, -16, 21, 23, -50, -30, -49, 30, 32, 100, 21 };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		shellSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}

}

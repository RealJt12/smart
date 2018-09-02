/**
 * QuickSort.java
 */
package com.realjt.smart.app;

/**
 * 快速排序
 * 
 * @author RealJt
 * @date 2018年7月15日
 */
public class QuickSort
{
	private static void swap(int[] data, int i, int j)
	{
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private static void subSort(int[] data, int start, int end)
	{
		if (start < end)
		{
			int i = start;
			int j = end + 1;

			while (true)
			{
				while (i < end && data[++i] <= data[start])
					;
				while (j > start && data[--j] >= data[start])
					;

				if (i < j)
				{
					swap(data, i, j);
				}
				else
				{
					break;
				}
			}

			swap(data, start, j);

			subSort(data, start, j - 1);
			subSort(data, j + 1, end);
		}
	}

	public static void quickSort(int[] data)
	{
		subSort(data, 0, data.length - 1);
	}

	public static void main(String[] args)
	{
		int[] data = { 9, -16, 21, 23, -50, -30, -49, 21, 32, 30 };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		quickSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}

}

package com.realjt.smart.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.realjt.smart.domain.User;

/**
 * 集合测试
 * 
 * @author RealJt
 * @date 2018年6月24日
 */
public class AppTest
{
	public void test()
	{
		Collection<Object> collection = new ArrayList<>();

		collection.add("realjt");
		collection.add("realjt");
		collection.add(12);

		collection.remove("realjt");
		collection.remove("realjt");
		System.out.println(collection);

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("12");

		list.remove("a");
		System.out.println(list);

		String s1 = "xd";
		String s2 = "xd";
		System.out.println(s1 == s2);

		Set<User> userSet = new HashSet<>();

		User user1 = new User("1", "1");
		User user2 = new User("2", "2");

		userSet.add(user1);
		userSet.add(user2);

		System.out.println(user1.hashCode());
		System.out.println(user2.hashCode());

		System.out.println(userSet);

		Set<User> userTreeSet = new TreeSet<>();
		userTreeSet.add(user1);
		userTreeSet.add(user2);

		System.out.println(userTreeSet);
	}

	public void test1()
	{
		Map<User, String> map = new HashMap<>(16);

		User user = new User("1", "realjt");

		map.put(user, "1_realjt");
		user.setId("2");

		map.put(new User("2", "realjt"), "2_realjt");

		System.out.println(map.get(new User("1", "realjt")));

		for (Map.Entry<User, String> element : map.entrySet())
		{
			System.out.println(element.getKey() + "---" + element.getValue());
		}
	}

	public void test2()
	{
		Thread t = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println(Thread.currentThread().getName());
				try
				{
					Thread.sleep(100000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		t.setName("main1");
		t.start();

		Thread t1 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println(Thread.currentThread().getName());
				try
				{
					Thread.sleep(10000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		t1.setName("main1");
		t1.start();
	}

}

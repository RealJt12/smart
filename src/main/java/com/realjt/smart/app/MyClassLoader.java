/**
 * MyClassLoader.java
 */
package com.realjt.smart.app;

/**
 * 
 * @author RealJt
 * @date 2018年7月31日
 */
public class MyClassLoader extends ClassLoader
{
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException
	{
		// TODO Auto-generated method stub

		return super.loadClass(name);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		// TODO Auto-generated method stub
		return super.findClass(name);
	}

}

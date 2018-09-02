package com.realjt.smart.common.config;

import javax.servlet.ServletContext;

/**
 * 配置类，使用单例模式
 * 
 * @author RealJt
 * @date 2018年6月23日
 */
public final class Config
{
	private static Config config = new Config();

	private static PropertyConfigurer propertyConfigurer;

	/**
	 * 部署后tomcat路径
	 */
	public static final String TOMCAT_PATH = "tomcat.path";

	/**
	 * web应用名称
	 */
	public static final String APPLICATION_NAME = "application.name";

	/**
	 * web应用路径
	 */
	public static final String APPLICATION_PATH = "application.path";

	private Config()
	{
	}

	public static Config getInstance(PropertyConfigurer propertyConfigurer, ServletContext servletContext)
	{
		Config.propertyConfigurer = propertyConfigurer;

		Config.propertyConfigurer.getProperties().setProperty(TOMCAT_PATH, System.getProperty("catalina.home"));
		Config.propertyConfigurer.getProperties().setProperty(APPLICATION_NAME,
				servletContext.getContextPath().replace("/", ""));
		Config.propertyConfigurer.getProperties().setProperty(APPLICATION_PATH,
				servletContext.getRealPath("").substring(0, servletContext.getRealPath("").length() - 1));

		servletContext.setAttribute(APPLICATION_NAME, "Smart");

		return config;
	}

	/**
	 * 获取一个配置项
	 * 
	 * @param key
	 *            键名称
	 * @return 键值
	 */
	public static String getString(String key)
	{
		return propertyConfigurer.getProperties().getProperty(key);
	}

	/**
	 * 获取一个配置项
	 * 
	 * @param key
	 *            键名称
	 * @param defaultValue
	 *            获取不到的情况下返回该默认值
	 * @return 键值
	 */
	public static String getString(String key, String defaultValue)
	{
		return propertyConfigurer.getProperties().getProperty(key, defaultValue);
	}

	public static int getInt(String key)
	{
		return Integer.valueOf(propertyConfigurer.getProperties().getProperty(key));
	}

	public static int getInt(String key, int defaultValue)
	{
		return Integer.valueOf(propertyConfigurer.getProperties().getProperty(key, String.valueOf(defaultValue)));
	}

}

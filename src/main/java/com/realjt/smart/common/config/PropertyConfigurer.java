package com.realjt.smart.common.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

/**
 * 复写PropertyPlaceholderConfigurer类，在加载配置时保存properties
 * 
 * @author RealJt
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer
{
	private Properties properties;

	private Resource[] resources;

	@Override
	public void setLocations(Resource... locations)
	{
		super.setLocations(locations);

		resources = locations;
	}

	@Override
	protected Properties mergeProperties() throws IOException
	{
		properties = super.mergeProperties();

		return properties;
	}

	public Properties getProperties()
	{
		return properties;
	}

	public Resource[] getResources()
	{
		return resources;
	}

}

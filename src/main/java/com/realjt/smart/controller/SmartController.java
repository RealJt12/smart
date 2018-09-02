package com.realjt.smart.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.realjt.smart.common.config.Config;

/**
 * 
 * 
 * @author RealJt
 * @date 2018年6月27日
 */
@Controller
public class SmartController
{
	private static final Logger log = LoggerFactory.getLogger(SmartController.class);

	@RequestMapping(value = "/smart")
	@ResponseBody
	public String smart()
	{
		log.info(Config.getString(Config.TOMCAT_PATH));
		log.info(Config.getString(Config.APPLICATION_NAME));

		return Config.getString(Config.APPLICATION_PATH) + " 什么是勇敢";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(HttpServletRequest request, HttpServletResponse response)
	{
		String repositoryPath = Config.getString(Config.APPLICATION_PATH) + File.separator + "WEB-INF" + File.separator
				+ "temp";

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 5);

		File file = new File(repositoryPath);
		if (!file.exists())
		{
			file.mkdirs();
		}
		factory.setRepository(file);

		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		servletFileUpload.setSizeMax(1024 * 1024 * 100);

		try
		{
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			for (FileItem fileItem : fileItems)
			{
				if (fileItem.isFormField())
				{
					log.info(fileItem.getFieldName() + "=" + fileItem.getString(StandardCharsets.UTF_8.name()));
				}
				else
				{
					String fieldName = fileItem.getFieldName();
					String fileName = fileItem.getName();
					String contentType = fileItem.getContentType();
					boolean isInMemory = fileItem.isInMemory();
					long sizeInBytes = fileItem.getSize();

					log.info("fieldName=" + fieldName + ",fileName=" + fileName + ",contentType=" + contentType
							+ ",isInMemory=" + isInMemory + ",sizeInBytes=" + sizeInBytes);

					fileItem.write(new File(repositoryPath + File.separator + fileName));
				}
			}
		}
		catch (FileUploadException e)
		{
			log.error("file upload error", e);
		}
		catch (UnsupportedEncodingException e)
		{
			log.error("file upload error", e);
		}
		catch (Exception e)
		{
			log.error("file upload error", e);
		}

		return "upload success";
	}

	@RequestMapping(value = "/hello", params = { "name", "age!=20" })
	public String hello(HttpServletRequest request, HttpServletResponse response)
	{
		return "success";
	}

	@RequestMapping("/pathvariable/{id}/details")
	public String pathVariable(@PathVariable("id") Integer id)
	{
		System.out.println(id);

		return "success";
	}

	@RequestMapping("/requestparam")
	public String requestParam(@RequestParam(value = "id", defaultValue = "0") Integer id,
			@RequestParam(value = "name", required = false) String name)
	{
		System.out.println(id);
		System.out.println(name);

		return "success";
	}

	/**
	 * 会把ModelAndView中的Model数据放到request域对象中
	 * 
	 * @return
	 */
	@RequestMapping("modelandview")
	public ModelAndView modelAndView()
	{
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("name", "RealJt");

		return modelAndView;
	}

}

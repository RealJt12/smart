package com.realjt.smart.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @author RealJt
 * @date 2018年6月27日
 */
public class DownloadServlet extends HttpServlet
{
	private static final long serialVersionUID = 9189357081713707459L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("application/x-msdownload");

		String fileName = "abc.txt";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8.displayName()));

		request.getLocale();
		
		response.getOutputStream();
	}

}

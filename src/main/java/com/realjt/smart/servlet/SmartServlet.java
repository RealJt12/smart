package com.realjt.smart.servlet;

import java.io.IOException;

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
public class SmartServlet extends HttpServlet
{
	private static final long serialVersionUID = 1093068431684465016L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().println("SmartServlet GET");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().println("SmartServlet POST");
	}

}

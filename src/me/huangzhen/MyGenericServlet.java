package me.huangzhen;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class MyGenericServlet implements Servlet,ServletConfig
{

	private ServletConfig servletConfig;
	
	
	// Servlet 接口中的方法
	@Override
	public void destroy()
	{
		
	}

	@Override
	public ServletConfig getServletConfig()
	{
		return servletConfig;
	}

	@Override
	public String getServletInfo()
	{
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException
	{
		this.servletConfig = servletConfig;
		init();
	}

	public void init()
	{
		
	}

	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException;

	
	// servletConfig 接口中的方法
	@Override
	public String getInitParameter(String arg0)
	{
		return servletConfig.getInitParameter(arg0);
	}

	@Override
	public Enumeration<String> getInitParameterNames()
	{
		return servletConfig.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext()
	{
		return servletConfig.getServletContext();
	}

	@Override
	public String getServletName()
	{
		return servletConfig.getServletName();
	}

}

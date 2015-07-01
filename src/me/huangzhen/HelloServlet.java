package me.huangzhen;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet
{

	@Override
	public void destroy()
	{
		System.out.println( " destroy " );
		
	}

	@Override
	public ServletConfig getServletConfig()
	{
		System.out.println( " getServletConfig " );
		return null;
	}

	@Override
	public String getServletInfo()
	{
		System.out.println( " getServletInfo " );
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException
	{
		System.out.println( " init " );
		String user = servletConfig.getInitParameter("user");
		System.out.println("user:" + user);
		
		Enumeration<String> names = servletConfig.getInitParameterNames();
		String name;
		while(names.hasMoreElements())
		{
			name = names.nextElement();
			System.out.println( "name:" + name + "  value" + servletConfig.getInitParameter(name)   );
		}
		
		String servletName = servletConfig.getServletName();
		System.out.println("servletName:" + servletName);
		
		ServletContext servletContext = servletConfig.getServletContext();
		
		String driver = servletContext.getInitParameter("driver");
		System.out.println("mysql's driver£º " + driver);
		
		Enumeration<String> names2 = servletContext.getInitParameterNames();
		String name2;
		while(names2.hasMoreElements())
		{
			name2 = names2.nextElement();
			System.out.println("name:" + name2 + " value:" + servletContext.getInitParameter(name2));
		}
		
		String realUrl = servletContext.getRealPath("/customer.jpg");
		System.out.println("realUrl:" + realUrl);
		
		String webName = servletContext.getContextPath();
		System.out.println("webName:" + webName);
		
		
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream("jdbc.properties");
		System.out.println("1." + is );
		
		InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
		System.out.println("2." +is2);
		
	}

	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException
	{
		System.out.println( " service " );
		
	}
	
	public HelloServlet()
	{
		System.out.println( " HelloServlet's constructor... " );
	}

}

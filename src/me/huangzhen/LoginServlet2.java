package me.huangzhen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet2 implements Servlet
{

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	ServletConfig servletConfig;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException
	{
		this.servletConfig = servletConfig;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException
	{
		
		System.out.println("login2...");
		
		//1. ��ȡ�ͻ���д������
		String clientUser = request.getParameter("user");
		String clientPassword = request.getParameter("password");
		
		//2. ��ȡwebӦ�õ�������Ϣ
		String paramUser = servletConfig.getServletContext().getInitParameter("user");
		String paramPassword = servletConfig.getServletContext().getInitParameter("password");
		
		//3. ��ȡ��ӡ��
		PrintWriter out = response.getWriter();
		
		
		if (clientUser.equals(paramUser) && clientPassword.equals(paramPassword))
		{
			out.print("Hello:" + clientUser);
		}else {
			out.print("Sorry:" + clientUser);
		}
		
		
	}

}

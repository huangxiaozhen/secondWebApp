package me.huangzhen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends MyGenericServlet
{

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException
	{
		if (request instanceof HttpServletRequest)
		{
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			if (response instanceof HttpServletResponse)
			{
				HttpServletResponse httpServletResponse = (HttpServletResponse) response;

				service(httpServletRequest, httpServletResponse);
			}
		}
	}

	public void service(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException
	{
		//1. ��ȡ����ķ�ʽ
		String method = httpServletRequest.getMethod();
		
		//2. ��������ʽ��������Ӧ�ķ���
		if ("GET".equalsIgnoreCase(method))
		{
			doGet(httpServletRequest,httpServletResponse);
		}else if ("POST".equalsIgnoreCase(method))
		{
			doPost(httpServletRequest,httpServletResponse);
		}
	}

	public void doPost(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException
	{
		
	}

	public void doGet(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
	{
		
	}

}

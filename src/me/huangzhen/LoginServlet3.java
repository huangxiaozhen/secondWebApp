package me.huangzhen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet3 extends MyGenericServlet
{

	@Override
	public void init()
	{
		super.init();
		System.out.println("��ʼ��");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException
	{

		System.out.println("login3...");

		// 1. ��ȡ�ͻ���д������
		String clientUser = request.getParameter("user");
		String clientPassword = request.getParameter("password");

		// 2. ��ȡwebӦ�õ�������Ϣ
		String paramUser = getServletContext().getInitParameter("user");
		String paramPassword = getServletContext().getInitParameter("password");

		// 3. ��ȡ��ӡ��
		PrintWriter out = response.getWriter();

		if (clientUser.equals(paramUser)
				&& clientPassword.equals(paramPassword))
		{
			out.print("Hello:" + clientUser);
		} else
		{
			out.print("Sorry:" + clientUser);
		}
	}

}

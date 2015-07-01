package me.huangzhen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet4 extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		System.out.println("login4...");

		// 1. 获取客户填写的资料
		String clientUser = request.getParameter("user");
		String clientPassword = request.getParameter("password");

		// 2. 获取web应用的配置信息
		String paramUser = getServletContext().getInitParameter("user");
		String paramPassword = getServletContext().getInitParameter("password");

		// 3. 获取打印流
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

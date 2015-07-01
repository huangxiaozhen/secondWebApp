package me.huangzhen;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.ClusterValve;

public class LoginServlet5 extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		//1.获取页面的信息
		System.out.println("doPost...");
		String clientUseName = req.getParameter("username");
		String clientPassword = req.getParameter("password");
		
		System.out.println( "userName:" + clientUseName + " password:" + clientPassword );
		
		//2. 连接数据库
		Properties properties = new Properties();
		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/classes/jdbc.properties");
		properties.load(is);
		
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		PrintWriter out = resp.getWriter();
		
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println( "connection:" + connection );
			
			//3. 进行查询
			
			String sql = "select * from test_users where user = ? and password = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, clientUseName);
			preparedStatement.setString(2, clientPassword);
			
			resultSet = preparedStatement.executeQuery();
			
			if( resultSet.next() )
			{
				out.print("Welcome:" + clientUseName);
				return ;
			}
			
			out.print("Sorry:" + clientUseName);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

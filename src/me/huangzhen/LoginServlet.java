package me.huangzhen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet implements Servlet
{

	@Override
	public void destroy()
	{
		
	}

	@Override
	public ServletConfig getServletConfig()
	{
		return null;
	}

	@Override
	public String getServletInfo()
	{
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException
	{
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("«Î«Û¿¥¡À...");
		System.out.println( request );
		
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
        System.out.println("user:" + user + " password:" +password);	
        
        String[] values = request.getParameterValues("interestings") ;
        System.out.print( "value: ");
        for( String value: values )
        {
        	System.out.print( value + "," );
        }
        System.out.println();
        
        
        Enumeration<String> names = request.getParameterNames();
        System.out.print( "Paramas: ");
        while(names.hasMoreElements())
        {
        	System.out.print( names.nextElement() + ",");
        }
		
        
        Map<String, String[]> maps = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = maps.entrySet();
        for( Map.Entry<String, String[]> entry :entries )
        {
        	System.out.println( "key:" + entry.getKey() + " vlaue:" + Arrays.asList(entry.getValue()));
        }
        
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        
        String requestUri = httpServletRequest.getRequestURI();
        System.out.println( "requestURI:" + requestUri);
        
        String method = httpServletRequest.getMethod();
        System.out.println( "method:" + method );
        
        String queryString = httpServletRequest.getQueryString();
        System.out.println( "queryString:" + queryString );
        
        String servletPath = httpServletRequest.getServletPath();
        System.out.println("servletPath:" + servletPath);
        
        
        //response
        PrintWriter out = response.getWriter();
        response.setContentType("application/msword");
        
        out.print("helloWorld...");
        
        
        
        
	}

}

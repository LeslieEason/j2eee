import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	public void init() throws ServletException
	{
		System.out.println("HelloServlet starting...");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response){
		
		try {
			response.getWriter().println("<h1>Hello Servlet!</h1>");
			response.getWriter().println(new Date().toLocaleString());
			System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
			System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
			System.out.println("请求行中的参数部分: " + request.getQueryString());
			System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
			System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
			System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
			System.out.println("服务器的IP地址: " + request.getLocalAddr());
			System.out.println("服务器的主机名: " + request.getLocalName());
			System.out.println("得到客户机请求方式: " + request.getMethod());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

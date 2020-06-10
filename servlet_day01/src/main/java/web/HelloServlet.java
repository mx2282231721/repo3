package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	/**
	 * 1.该方法用来处理请求（即容器收到请求之后，会调用
	 * Servlet的service方法来回力请求）
	 * 2.容器在调用service方法时，会将request对象和response对象作为参数传进来
	 * 注：request对象：容器收到请求之后，会解析请求数据包，然后将解析到的数据存
	 * 放到request对象里面，开发人员只需要调用request对象的方法就可以获得请求数据包
	 * response对象：开发人员只需要即将处理结果添加到response，容器会从response
	 * 对象上获得处理结果，然后创建响应数据包并发给浏览器
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String number = request.getParameter("number");
		String uname = request.getParameter("uname");
		
		/*
		 * 设置content-type消息头的值，告知浏览器，服务器返回的数据类型
		 */
		response.setContentType("text/html:charset=utf-8");
		/*
		 * 通过response对象获得输出流
		 */
		PrintWriter pw = response.getWriter();
		/*
		 * 将处理结果添加到了response对象上
		 * 
		 * pw.println方法默认会使用iso-8859-1来编码，如果有中文
		 * 会产生乱码,加上charaset=utf-8可以了
		 */
		pw.println("<h1>Hello "+uname+"</h1>");
		/*
		 * 关闭流
		 * 容器在关闭流之前，会将response对象上的存放的数据取出来，创建响应数据包
		 * 然后发送给浏览器。
		 */
		pw.close();
	}

	
}

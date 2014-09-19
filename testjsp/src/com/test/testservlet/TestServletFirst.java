package com.test.testservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServletFirst
 */
@WebServlet(description = "desc", urlPatterns = { "/aa/TestServletFirst" })
public class TestServletFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServletFirst() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("UTF8");
		
		//response.setContentType("text/html;charSet=utf8");
		PrintWriter out=response.getWriter();
		String ip=request.getParameter("ip");
		out.println("<html><head><title>testservlet</title></head><body>hello servlet");
		out.println("<h1>" + ip +"</h1>");
		out.println("</body></html>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String ip=request.getParameter("ip");
		out.println("<html><head><title>testservlet</title></head><body>hello servlet");
		out.println("<h1>" + ip +"</h1>");
		out.println("</body></html>");
	}

}

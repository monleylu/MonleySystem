package com.test.testservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.db.UerNameDB;

/**
 * Servlet implementation class LoginVerify
 */
@WebServlet(name = "verifyusername", description = "testverify username", urlPatterns = { "/loginverify" })
public class LoginVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		String errMsg="";
		String username=request.getParameter("loginname");
		UerNameDB userName= new UerNameDB();
		userName.setUsername("lujian");
		if(userName.getUsername().equals(username)){
			HttpSession httpSess=request.getSession();
			httpSess.setAttribute("username", username);
			rd=request.getRequestDispatcher("/welcom.jsp");
			rd.forward(request, response);
		}
		else{
			errMsg="User does not exist";
			rd=request.getRequestDispatcher("/login.jsp");
			request.setAttribute("errqq", errMsg);
			rd.forward(request, response);
		}
		
	}

}

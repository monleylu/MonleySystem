package com.test.testservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.test.db.Daodb;

/**
 * Servlet implementation class SaveProj
 */
@WebServlet("/saveproj")
public class SaveProj extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out=response.getWriter();
		
		//out.print(strjson);
		String resid=request.getParameter("resid");
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		Daodb db = new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		try {
			if(db.insert("insert into projcatalog(resid,name ,description ) values(?,?,?)", resid,name,desc)){
				Succ s1=new Succ();
				s1.setSuccess(true);
				String strjson=JSON.toJSONString(s1);
				out.print(strjson);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorMsg e1=new ErrorMsg();
			e1.setErrorMsg("insert error message error");
			String strjson=JSON.toJSONString(e1);
			out.print(strjson);
			e.printStackTrace();
		}
	}

}


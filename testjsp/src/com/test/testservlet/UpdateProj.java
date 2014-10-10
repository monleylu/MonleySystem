package com.test.testservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.test.db.Daodb;

/**
 * Servlet implementation class UpdateProj
 */
@WebServlet("/updateproj")
public class UpdateProj extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=0;
		String strid=request.getParameter("id");
		String resid=request.getParameter("resid");
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		PrintWriter out=response.getWriter();
		if(strid!=null){
			id=Integer.parseInt(strid);
		}
		Daodb db=new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		
		try {
			db.modify("update ProjCatalog set resid=? ,name=?,description=? where id=?", resid,name,desc,id);
			Succ s1=new Succ();
			s1.setSuccess(true);
			String strjson=JSON.toJSONString(s1);
			out.print(strjson);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorMsg e1=new ErrorMsg();
			e1.setErrorMsg("update error message error");
			String strjson=JSON.toJSONString(e1);
			out.print(strjson);
			e.printStackTrace();
		}finally{
			try {
				db.closeConn();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

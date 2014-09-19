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
 * Servlet implementation class UpdateRes
 */
@WebServlet("/updateRes")
public class UpdateRes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		
		int id=0;
		String strid=request.getParameter("id");
		int resid=Integer.parseInt(request.getParameter("resid"));
		String machinetype=request.getParameter("machinetype");
		String ip=request.getParameter("ip");
		String ostype=request.getParameter("ostype");
		String diskinfo=request.getParameter("diskinfo");
		String memory=request.getParameter("memory");
		int hba=Integer.parseInt(request.getParameter("hba"));
		String position=request.getParameter("position");
		int mode=Integer.parseInt(request.getParameter("mode"));
		String description=request.getParameter("description");
		
		if(strid!=null){
			id=Integer.parseInt(strid);
		}
		
		Daodb db=new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		
		try {
			
			db.modify("update serviceDevInformation set resid=? ,machinetype=?, ip =inet_aton(?) ,ostype=?,diskinfo=?,memory=?,hba=?,position=?,mode=?,description=? where id=?", resid,machinetype,ip,ostype,diskinfo,memory,hba,position,mode,description,id);
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
		}
		
	}

}

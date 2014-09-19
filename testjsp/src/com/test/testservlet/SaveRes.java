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
 * Servlet implementation class SaveRes
 */
@WebServlet("/saveRes")
public class SaveRes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		//out.print(strjson);
/*		int resid=Integer.parseInt(request.getParameter("resid"));
		String machinetype=request.getParameter("machinetype");
		String ip=request.getParameter("ip");
		String ostype=request.getParameter("ostype");
		String diskinfo=request.getParameter("diskinfo");
		String memory=request.getParameter("memory");
		int hba=Integer.parseInt(request.getParameter("hba"));
		String position=request.getParameter("position");
		int mode=Integer.parseInt(request.getParameter("mode"));
		String description=request.getParameter("description");*/
		
		int resid=Integer.parseInt(request.getParameter("resid"));
		String machinetype=request.getParameter("machinetype");
		if(machinetype==null){
			machinetype="";
		}
		
		String ip=request.getParameter("ip");
		String ostype=request.getParameter("ostype");
		if(ostype==null){
			ostype="";
		}
		
		String diskinfo=request.getParameter("diskinfo");
		if(diskinfo==null){
			diskinfo="";
		}
		
		String memory=request.getParameter("memory");
		if(memory==null){
			memory="";
		}
		
		int hba=0;
		String strhba=request.getParameter("hba");
		if(strhba!=null&&!strhba.equals("")){
			hba=Integer.parseInt(strhba);
		}
		
		String position=request.getParameter("position");
		if(position==null){
			position="";
		}
		int mode=Integer.parseInt(request.getParameter("mode"));
		String description=request.getParameter("description");
		if(description==null){
			description="";
		}
		
		
			
		
		
		Daodb db = new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		try {
			if(db.insert("insert into serviceDevInformation(resid,machinetype,ip,ostype,diskinfo,memory,hba,position,mode,description ) values(?,?,inet_aton(?),?,?,?,?,?,?,?)", resid,machinetype,ip,ostype,diskinfo,memory,hba,position,mode,description)){
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

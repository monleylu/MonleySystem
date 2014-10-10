package com.test.testservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.JSONObjectDeserializer;
import com.db.table.GetAssociateResItem;
import com.test.db.Daodb;

/**
 * Servlet implementation class GetAssociateResource
 */
@WebServlet("/getassociateresource")
public class GetAssociateResource extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int resid=Integer.parseInt(request.getParameter("resid"));
		
		Daodb db = new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		ArrayList<GetAssociateResItem> a1= new ArrayList<>();
		
		try {
			ResultSet rs=db.query("select serviceDevInformation.resid ,serviceDevInformation.machinetype ,inet_ntoa(serviceDevInformation.ip) as ip ,ResourceTypeCatalog.name from serviceDevInformation inner join  ResourceTypeCatalog on ResourceTypeCatalog.resid=serviceDevInformation.resid where serviceDevInformation.mode=?", resid);
			while(rs.next()){
				GetAssociateResItem g1=new GetAssociateResItem();
				g1.setResId(rs.getInt("resid"));
				g1.setMachinetype(rs.getString("machinetype"));
				g1.setIp(rs.getString("ip"));
				g1.setResIdName(rs.getString("name"));
				a1.add(g1);
			}
			String json=JSON.toJSONString(a1);
			out.print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

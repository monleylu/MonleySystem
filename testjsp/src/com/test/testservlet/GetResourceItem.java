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
import com.db.menulist.ResourceMenuList;
import com.test.db.Daodb;

/**
 * Servlet implementation class GetResourceItem
 */
@WebServlet("/getresourceitem")
public class GetResourceItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		ArrayList<ResourceMenuList> al=new ArrayList<ResourceMenuList>();
		Daodb db = new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		
		try {
			ResultSet rs=db.query("select * from ResourceTypeCatalog");
			while(rs.next()){
				ResourceMenuList p1=new ResourceMenuList();
				p1.setId(rs.getInt("id"));
				p1.setText(rs.getString("name"));
				p1.setState("open");
				p1.setResid(rs.getInt("resid"));
				al.add(p1);
			}
			
			String json=JSON.toJSONString(al);
			out.print(json);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

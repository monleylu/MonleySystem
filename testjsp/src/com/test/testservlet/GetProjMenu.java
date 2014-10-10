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
import com.db.menulist.ProjMenuList;
import com.db.table.ProjCatalog;
import com.db.table.ProjCatalogInfo;
import com.test.db.Daodb;

/**
 * Servlet implementation class GetProjMenu
 */
@WebServlet(description = "get project menu", urlPatterns = { "/getprojmenu" })
public class GetProjMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		ArrayList<ProjMenuList> al=new ArrayList<ProjMenuList>();
		Daodb db = new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		
		try {
			ResultSet rs=db.query("select * from projcatalog");
			while(rs.next()){
				ProjMenuList p1=new ProjMenuList();
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

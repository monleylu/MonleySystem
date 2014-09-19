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
import com.db.table.ProjCatalog;
import com.db.table.ProjCatalogInfo;
import com.test.db.Daodb;

/**
 * Servlet implementation class GetProjInfo
 */
@WebServlet("/getprojinfo")
public class GetProjInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		int offset=(page-1)*rows;
		
		ArrayList<ProjCatalog> al=new ArrayList<ProjCatalog>();
		ProjCatalogInfo allProj=new ProjCatalogInfo();
		Daodb db = new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		
		try {
			
		 	
		 	ResultSet rs1=db.query("select count(1) as total from projcatalog" );
		 	rs1.next();
		 	allProj.setTotal(rs1.getInt("total"));
		 	ResultSet rs=db.query("select * from projcatalog limit ?, ? " ,offset,rows);
			while(rs.next()){
				ProjCatalog p1=new ProjCatalog();
				p1.setId(rs.getInt("id"));
				p1.setResid(rs.getInt("resid"));
				p1.setName(rs.getString("name"));
				//p1.setName(new String(((rs.getString("name")).getBytes("utf-8")),"utf-8"));
				p1.setDesc(rs.getString("description"));
				al.add(p1);
			}
			allProj.setRows(al);
			String json=JSON.toJSONString(allProj);
			out.print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
/*
class ProjCatalog{
	private int id;
	private int resid;
	private String name;
	private String desc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
*/
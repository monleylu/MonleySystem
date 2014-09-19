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
import com.db.table.ServiceDevInformation;
import com.db.table.ServiceDevInformationSum;
import com.test.db.Daodb;

/**
 * Servlet implementation class GetResource
 */
@WebServlet("/getresource")
public class GetResource extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int resid=Integer.parseInt(request.getParameter("resid"));
		int page=Integer.parseInt(request.getParameter("page"));
		int rows=Integer.parseInt(request.getParameter("rows"));
		int offset=(page-1)*rows;
		
		ArrayList<ServiceDevInformation> al=new ArrayList<ServiceDevInformation>();
		ServiceDevInformationSum allRes=new ServiceDevInformationSum();
		Daodb db = new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		
		try {
			
		 	
		 	ResultSet rs1=db.query("select count(1) as total from serviceDevInformation" );
		 	rs1.next();
		 	allRes.setTotal(rs1.getInt("total"));
		 	ResultSet rs=db.query("select serviceDevInformation.id,serviceDevInformation.resid,machinetype,inet_ntoa(ip) as ip,ostype,diskinfo,memory,hba,position,mode,serviceDevInformation.description ,projCatalog.name from serviceDevInformation inner join ProjCatalog on serviceDevInformation.mode=ProjCatalog.resid where serviceDevInformation.resid = ? limit ?, ? " ,resid,offset,rows);
			while(rs.next()){
				ServiceDevInformation p1=new ServiceDevInformation();
				p1.setId(rs.getInt("id"));
				p1.setResid(rs.getInt("resid"));
				p1.setMachinetype(rs.getString("machinetype"));
				p1.setIp(rs.getString("ip"));
				p1.setOstype(rs.getString("ostype"));
				p1.setDiskinfo(rs.getString("diskinfo"));
				p1.setMemory(rs.getString("memory"));
				p1.setHba(rs.getInt("hba"));
				p1.setPosition(rs.getString("position"));
				p1.setMode(rs.getInt("mode"));
				p1.setModeName(rs.getString("name"));
				p1.setDescription(rs.getString("description"));
				al.add(p1);
			}
			
			allRes.setRows(al);
			String json=JSON.toJSONString(allRes);
			out.print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

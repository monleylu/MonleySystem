package com.test.testservlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.test.db.Daodb;

/**
 * Servlet implementation class ModifyDB
 */
@WebServlet(description = "modify db soure", urlPatterns = { "/modify" })
public class ModifyDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=0;
		String strid=(String)request.getParameter("id");
		if(strid!=null){
			id= Integer.parseInt(strid);
		}
		Daodb db=new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","security");
		try {
			ResultSet rs =db.query("select name ,description from catalog where id = ?", id);
			rs.next();
			String name = rs.getString("name");
			String desc = rs.getString("description");
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("desc", desc);
			request.getRequestDispatcher("/adddata.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package com.test.testservlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.db.Daodb;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet(description = "option to get data from mysql", urlPatterns = { "/showservlet" })
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Daodb db=new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","security");
		Daodb db=new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		try {
			ResultSet rs = db.query("select id ,name ,description from ProjCatalog");
			ArrayList<Catalog> list = new ArrayList<Catalog>();
			while(rs.next()){
				Catalog cl= new Catalog();
				cl.setId(rs.getInt("id"));
				cl.setName(rs.getString("name"));
				cl.setDesc(rs.getString("description"));
				list.add(cl);
			}
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/show.jsp").forward(request, response);
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

package com.test.testservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.db.Daodb;

/**
 * Servlet implementation class DeleteDB
 */
@WebServlet(description = "adfadfdfdaf", urlPatterns = { "/delete" })
public class DeleteDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id =0;
		if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
			id=(Integer.parseInt((String)request.getParameter("id")));
		}
		
		Daodb db=new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","security");
		try {
			db.modify("delete from catalog where id = ? ", id);
			request.getRequestDispatcher("/showservlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

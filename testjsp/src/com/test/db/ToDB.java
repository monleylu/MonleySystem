package com.test.db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToDB
 */
@WebServlet("/todb")
public class ToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=0;
		if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
			id=(Integer.parseInt((String)request.getParameter("id")));
		}
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		//Daodb db = new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test","root","security");
		Daodb db = new Daodb("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/ms","root","security");
		if(id ==0){
			try {
				
				if(db.insert("insert into ProjCatalog(resid,name ,description ) values(?,?,?)",12, name,desc)){
					request.getRequestDispatcher("/showservlet").forward(request, response);
				}
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
			
		}else{
			
			try {
				db.modify("update ProjCatalog set resid=12, name= ?,description =? where id =?", name,desc,id);
				request.getRequestDispatcher("showservlet").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		
	}

}

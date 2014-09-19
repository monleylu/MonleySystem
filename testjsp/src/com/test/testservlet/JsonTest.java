package com.test.testservlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.*;
/**
 * Servlet implementation class JsonTest
 */
@WebServlet(description = "asdfasdf", urlPatterns = { "/jsontest" })
public class JsonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("utf-8");
		user u1=new user();
		u1.setId(1);
		u1.setText("DFDn你");
		u1.setAge(27);
		user u2=new user();
		u2.setText("tst");
		u2.setAge(100);
		ArrayList<user> a1=new ArrayList<>();
		a1.add(u1);
		a1.add(u2); 
		Alluser au=new Alluser();
		au.setCount(a1.size());
		au.setAlusers(a1);
		//String json=JSON.toJSONString(u1);
		String json1=JSON.toJSONString(au);
		//System.out.p
		System.out.println(json1 + u1.getText());
		out.print(json1);
	//	out.print(json1);
		
		//request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

}


class Alluser{
	
	private int count;
	private ArrayList<user> alusers;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public ArrayList<user> getAlusers() {
		return alusers;
	}
	public void setAlusers(ArrayList<user> alusers) {
		this.alusers = alusers;
	}
	
}

class user{
	private int id;
	private String text;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}



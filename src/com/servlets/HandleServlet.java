package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.Books;
import com.demo.ConnectDB;

/**
 * Servlet implementation class HandleServlet
 */
@WebServlet("/HandleServlet")
public class HandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		if(request.getParameter("cbutton")!=null)
		{
			ConnectDB handle = new ConnectDB();
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			Double price = Double.parseDouble(request.getParameter("price"));
			handle.create(title,author,price);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			out.println("<h2>Record Created Successfully!</h2>");
			out.println("<a href = 'index.html'>Return to Home Page</a>");
		}
		
		
		else if(request.getParameter("Read")!= null)
		{
			ConnectDB handle = new ConnectDB();
    		ResultSet rs = handle.fetch(Integer.parseInt(request.getParameter("bid")));
    		try
    		{
    			ArrayList<Books> Rows = new ArrayList<>();

     		   while (rs.next()){
     		       Rows.add(new Books(rs.getInt("id"),rs.getString("title"), rs.getString("author"), rs.getDouble("price")));
     		       }
     		  
     		 request.setAttribute("List", Rows);
     		 RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/display.jsp");
     		 requestDispatcher.forward(request,response);
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
		}
		
		else if(request.getParameter("Update")!=null)
		{
			ConnectDB handle = new ConnectDB();
			int id = Integer.parseInt(request.getParameter("bid"));
			double price = Double.parseDouble(request.getParameter("p_val"));
			
			handle.updatePrice(id, price);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			out.println("<h2>Record Updated Successfully!</h2>");
			out.println("<a href = 'index.html'>Return to Home Page</a>");
		}
		
		else if(request.getParameter("Delete")!= null)
		{
			ConnectDB handle = new ConnectDB();
			int id = Integer.parseInt(request.getParameter("bid"));
			
			handle.remove(id);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			out.println("<h2>Record Deleted Successfully!</h2>");
			out.println("<a href = 'index.html'>Return to Home Page</a>");
		}
		
	}

}

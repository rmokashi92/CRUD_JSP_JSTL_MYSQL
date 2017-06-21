package com.servlets;


import java.io.IOException;
//import java.io.PrintWriter;
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
 * Servlet implementation class CRUDServlet
 */
@WebServlet("/CRUDServlet")
public class CRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doGet(req, resp);
    	 
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if (request.getParameter("create") != null) {
            //out.println("Create");
			response.sendRedirect("create.html");
        } else if (request.getParameter("read") != null) {
        	//out.println("Read");
        	String str = new String("Read");
        	request.setAttribute("method", str);
        	RequestDispatcher reqdisp = getServletContext().getRequestDispatcher("/update.jsp");
        	reqdisp.forward(request, response);
        	
        } else if (request.getParameter("update") != null) {
        	//out.println("Update");
        	String str = new String("Update");
        	request.setAttribute("method", str);
        	RequestDispatcher reqdisp = getServletContext().getRequestDispatcher("/update.jsp");
        	reqdisp.forward(request, response);
        }
        else if(request.getParameter("delete") !=null)
		{
        	//out.println("Delete");
        	String str = new String("Delete");
        	request.setAttribute("method", str);
        	RequestDispatcher reqdisp = getServletContext().getRequestDispatcher("/update.jsp");
        	reqdisp.forward(request, response);
		}
        else if(request.getParameter("display") !=null){
        	//out.println("Display");
        	ConnectDB handle = new ConnectDB();
    		ResultSet rs = handle.displayAll();
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
            
		
		
	}

}

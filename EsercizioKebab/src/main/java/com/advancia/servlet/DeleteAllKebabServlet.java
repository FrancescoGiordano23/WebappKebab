package com.advancia.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.advancia.Utility.*;
import com.advancia.java.User;


public class DeleteAllKebabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteAllKebabServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("User");
		KebabServices.DeleteAllUserKebab(user);
		request.getRequestDispatcher("ShowKebabServlet").forward(request, response);
	}

}

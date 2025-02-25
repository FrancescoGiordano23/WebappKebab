package com.advancia.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;

import com.advancia.Utility.*;
import com.advancia.java.Container;
import com.advancia.java.Kebab;
import com.advancia.java.PrimaryIngredient;
import com.advancia.java.SauceIngredient;
import com.advancia.java.SecondaryIngredient;
import com.advancia.java.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		User user=UserServices.GetUser(username, password);
		if (user!=null) {
			request.getSession().setAttribute("User", user);
			createEnviroment(request, user);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			request.setAttribute("invalidCredentials", true);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
private void createEnviroment(HttpServletRequest request,User user) {
		
		
		List<Container> containers = KebabServices.GetAllContainers();
		List<PrimaryIngredient> primaryIgredients = KebabServices.GetAllPrimaryIngredients();
		List<SecondaryIngredient> secondaryIgredients = KebabServices.GetAllSecondaryIngredients();
		List<SauceIngredient> sauceIgredients = KebabServices.GetAllSauceIngredients();
		List<Kebab> kebabs = KebabServices.GetAllUserKebabs(user);
		
		if(user==null) 
			request.setAttribute("invalidUser", true);
		else
			request.setAttribute("invalidUser", null);
		
		request.getSession().setAttribute("User", user);
		request.setAttribute("PrimaryIngredients", primaryIgredients);
		request.setAttribute("SecondaryIngredients", secondaryIgredients);
		request.setAttribute("Sauces", sauceIgredients);
		request.setAttribute("Containers", containers);
		request.setAttribute("Kebabs", kebabs);
	}

}

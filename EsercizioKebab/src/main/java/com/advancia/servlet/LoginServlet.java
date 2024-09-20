package com.advancia.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;


import com.advancia.Utility.*;
import com.advancia.Entity.ContainerEntity;
import com.advancia.Entity.KebabEntity;
import com.advancia.Entity.PrimaryIngredientEntity;
import com.advancia.Entity.SauceIngredientEntity;
import com.advancia.Entity.SecondaryIngredientEntity;
import com.advancia.Entity.UserEntity;
import com.advancia.Modal.*;

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
		UserEntity user=UserServices.CheckAndGetUserByCredentials(username, password);
		if (user!=null) {
			request.getSession().setAttribute("User", user);
			createEnviroment(request, user);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			request.setAttribute("invalidCredentials", true);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
private void createEnviroment(HttpServletRequest request,UserEntity user) {
		
		
		List<ContainerEntity> containers = ContainerServices.getAllContainers();
		List<PrimaryIngredientEntity> primaryIgredients = PrimaryIngredientServices.getAllPrimaryIngredients();
		List<SecondaryIngredientEntity> secondaryIgredients = SecondaryIngredientServices.getAllSecondaryIngredients();
		List<SauceIngredientEntity> sauceIgredients = SauceIngredientServices.getAllSauceIngredients();
		List<KebabEntity> kebabs = KebabServices.GetAllUserKebabs(user);
		
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

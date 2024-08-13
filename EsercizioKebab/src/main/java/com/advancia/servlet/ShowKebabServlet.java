package com.advancia.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.advancia.Utility.*;
import com.advancia.Modal.*;


public class ShowKebabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowKebabServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user= (User) request.getSession().getAttribute("User");
		List<Container> containers = ContainerServices.getAllContainers();
		List<PrimaryIngredient> primaryIgredients = PrimaryIngredientServices.getAllPrimaryIngredients();
		List<SecondaryIngredient> secondaryIgredients = SecondaryIngredientServices.getAllSecondaryIngredients();
		List<SauceIngredient> sauceIgredients = SauceIngredientServices.getAllSauceIngredients();
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
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

}

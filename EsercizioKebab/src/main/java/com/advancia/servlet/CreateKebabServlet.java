package com.advancia.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import com.advancia.DAO.SauceIngredientDAO;
import com.advancia.Modal.*;

public class CreateKebabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateKebabServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// prendo tutti i dati di kebab da creare
		UserEntity user = (UserEntity) request.getSession().getAttribute("User");
		String selectedName = (String) request.getParameter("selectedName");
		int selectedContainerId = Integer.parseInt(request.getParameter("selectedContainerId"));
		int selectedPrimaryId = Integer.parseInt(request.getParameter("selectedPrimaryId"));

		String selectedSecondary = request.getParameter("selectedSecondaryIds");
		List<Integer> selectedSecondaryIds = new ArrayList<Integer>();
		if (selectedSecondary != null && !selectedSecondary.isEmpty()) {
			String[] tempSecondaryIds = selectedSecondary.split(",");
			// Now you have an array of selected secondary ingredient IDs
			for (String s : tempSecondaryIds) {
				if (!s.isBlank() && !s.isEmpty())
					selectedSecondaryIds.add(Integer.parseInt(s));
			}
		}

		String selectedSauce = request.getParameter("selectedSauceIds");
		List<Integer> selectedSauceIds = new ArrayList<Integer>();
		if (selectedSauce != null && !selectedSauce.isEmpty()) {
			String[] tempSauceIds = selectedSauce.split(",");
			// Now you have an array of selected secondary ingredient IDs
			for (String s : tempSauceIds) {
				if (!s.isBlank() && !s.isEmpty())
					selectedSauceIds.add(Integer.parseInt(s));
			}
		}

		if (KebabServices.GetKebabOfUserByName(user, selectedName) == null) {
			// Creo nuovo Kebab
			KebabServices.CreateNewKebab(selectedName, selectedContainerId, selectedPrimaryId, selectedSauceIds,
					selectedSecondaryIds, user, 0);
			request.setAttribute("invalidKebab", null);
		} else {
			request.setAttribute("invalidKebab", true);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		request.getSession().setAttribute("User", user);
		createEnviroment(request,response,user);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	private void createEnviroment(HttpServletRequest request,HttpServletResponse response,UserEntity user) {
		
		
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

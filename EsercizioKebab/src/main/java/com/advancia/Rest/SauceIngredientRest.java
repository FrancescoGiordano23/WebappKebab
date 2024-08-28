package com.advancia.Rest;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.advancia.Modal.SauceIngredient;
import com.advancia.Utility.SauceIngredientServices;

@Path("/ingredients/Sauce")
public class SauceIngredientRest {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<SauceIngredient> getAllSauceIngredients() {
		return SauceIngredientServices.getAllSauceIngredients();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public SauceIngredient getSauceIngredientById(@PathParam("id") int selectedSauceId) {
		return SauceIngredientServices.getSauceIngredientById(selectedSauceId);
	}

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteAllSauceIngredient() {
		SauceIngredientServices.deleteAllSauceIngredient();
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteSauceIngredientById(@PathParam("id") int selectedSauceId) {
		SauceIngredientServices.deleteSauceIngredientById(selectedSauceId);
	}

	@PUT
	@Path("/{id}/{name}/{price}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateSauceIngredientById(@PathParam("id") int selectedSauceId,
			@PathParam("name") String newName, @PathParam("price") int newPrice) {
		SauceIngredientServices.updateSauceIngredientById(selectedSauceId, newName, newPrice);
	}

	@POST
	@Path("/{name}/{price}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void createSauceIngredient(@PathParam("name") String name, @PathParam("price") int price) {
		SauceIngredientServices.createSauceIngredient(name, price);
	}

}

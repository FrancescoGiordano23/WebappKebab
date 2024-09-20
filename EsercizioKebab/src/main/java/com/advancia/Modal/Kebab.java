package com.advancia.Modal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.advancia.Entity.ContainerEntity;
import com.advancia.Entity.PrimaryIngredientEntity;
import com.advancia.Entity.SauceIngredientEntity;
import com.advancia.Entity.SecondaryIngredientEntity;
import com.advancia.Entity.UserEntity;

public class Kebab {

	
	private int id;	
	public int getId() {
		return id;
	}
	public void setId(int value) {
		id=value;
	}
	
	
	private String name;	
	public String getName() {
		return name;
	}
	public void setName(String value) {
		name=value;
	}
	
	
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int value) {
		price=value;
	}

	
	private PrimaryIngredientEntity primaryIngredient;
	public PrimaryIngredientEntity getPrimaryIngredient() {
		return primaryIngredient;
	}	
	public void setPrimaryIngredient(PrimaryIngredientEntity value) {
		primaryIngredient=value;
	}

	
	private ContainerEntity container;
	public ContainerEntity getContainer() {
		return container;
	}	
	public void setContainer(ContainerEntity value) {
		container=value;
	}
	
	
	private Set<SecondaryIngredientEntity> secondaryIngredientsSet = new HashSet<>();
	public Set<SecondaryIngredientEntity> getSecondaryIngredients(){
		return secondaryIngredientsSet;
	}
	public void addSecondaryIngredientToSet(SecondaryIngredientEntity value) {
		secondaryIngredientsSet.add(value);
	}
	public void removeSecondaryIngredientFromList(SecondaryIngredientEntity value) {
		secondaryIngredientsSet.remove(value);
	}

	
	private List<SauceIngredientEntity> sauceIngredientsList = new ArrayList<SauceIngredientEntity>();
	public List<SauceIngredientEntity> getSauceIngredients(){
		return sauceIngredientsList;
	}
	public void addSauceIngredientToList(SauceIngredientEntity value) {
		sauceIngredientsList.add(value);
	}
	public void removeSauceIngredientFromList(SauceIngredientEntity value) {
		sauceIngredientsList.remove(value);
	}

	
	private UserEntity user;	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity value) {
		user=value;
	}
}

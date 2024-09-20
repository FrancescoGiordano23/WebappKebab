package com.advancia.Entity;

import javax.persistence.*;

@Entity
@Table(name="secondary_ingredient_table")

@NamedQueries({
	
	@NamedQuery(name = "GetAllSecondaryIngredients", query = "SELECT s from SecondaryIngredientEntity s"),
	@NamedQuery(name = "GetSecondaryIngredientById", query = "SELECT s FROM SecondaryIngredientEntity s WHERE s.id= :id") })


public class SecondaryIngredientEntity {
	
	@Id	
	@Column(name="secondary_ingredient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	public int getId() {
		return id;
	}
	public void setId(int value) {
		id=value;
	}
	
	@Column(name="secondary_ingredient_name")
	private String name;	
	public String getName() {
		return name;
	}
	public void setName(String value) {
		name=value;
	}
	
	@Column(name="secondary_ingredient_price")	
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int value) {
		price=value;
	}

}

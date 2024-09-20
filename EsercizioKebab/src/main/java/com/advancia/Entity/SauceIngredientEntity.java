package com.advancia.Entity;

import javax.persistence.*;

@Entity
@Table(name = "sauce_ingredient_table")

@NamedQueries({

		@NamedQuery(name = "GetAllSauceIngredients", query = "SELECT s from SauceIngredientEntity s"),
		@NamedQuery(name = "GetSauceIngredientById", query = "SELECT s FROM SauceIngredientEntity s WHERE s.id = :id") })

public class SauceIngredientEntity {

	@Id
	@Column(name = "sauce_ingredient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int value) {
		id = value;
	}

	@Column(name = "sauce_ingredient_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String value) {
		name = value;
	}

	@Column(name = "sauce_ingredient_price")
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int value) {
		price = value;
	}

}

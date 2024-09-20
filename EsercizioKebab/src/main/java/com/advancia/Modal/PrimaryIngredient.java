package com.advancia.Modal;

import java.util.List;

import com.advancia.Entity.KebabEntity;

public class PrimaryIngredient {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int value) {
		id = value;
	}

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String value) {
		name = value;
	}

	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int value) {
		price = value;
	}

	private List<KebabEntity> kebabWithThisPrimaryList;
	public List<KebabEntity> getKebabWithThisPrimaryList(){
		return kebabWithThisPrimaryList;
	}
}

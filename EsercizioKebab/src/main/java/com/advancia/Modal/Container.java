package com.advancia.Modal;

import java.util.List;

import com.advancia.Entity.KebabEntity;

public class Container {
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

	
	private int price = 0;
	public int getPrice() {
		return price;
	}
	public void setPrice(int value) {
		price = value;
	}

	
	private List<KebabEntity> kebabWithThisContainerList;
}

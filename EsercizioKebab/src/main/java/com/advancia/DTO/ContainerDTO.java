package com.advancia.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.advancia.Entity.KebabEntity;

public class ContainerDTO {

	
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

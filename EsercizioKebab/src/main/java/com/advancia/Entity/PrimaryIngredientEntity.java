package com.advancia.Entity;

import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "primary_ingredient_table")

@NamedQueries({

		@NamedQuery(name = "GetAllPrimaryIngredients", query = "SELECT p from PrimaryIngredientEntity p"),
		@NamedQuery(name = "GetPrimaryIngredientById", query = "SELECT p FROM PrimaryIngredientEntity p WHERE p.id = :id")
})

public class PrimaryIngredientEntity {

	@Id
	@Column(name = "primary_ingredient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int value) {
		id = value;
	}

	@Column(name = "primary_ingredient_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String value) {
		name = value;
	}

	@Column(name = "primary_ingredient_price")
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int value) {
		price = value;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "primaryIngredient")
	private List<KebabEntity> kebabWithThisPrimaryList;

}

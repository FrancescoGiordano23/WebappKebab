package com.advancia.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "container_table")

@NamedQueries({ 
	@NamedQuery(name = "GetAllContainers", query = "SELECT c FROM ContainerEntity c"),
	@NamedQuery(name = "GetContainerById", query = "SELECT c FROM ContainerEntity c WHERE c.id =:id") 
	})
public class ContainerEntity {

	@Id
	@Column(name = "container_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int value) {
		id = value;
	}

	@Column(name = "container_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String value) {
		name = value;
	}

	@Column(name = "container_price")
	private int price = 0;

	public int getPrice() {
		return price;
	}

	public void setPrice(int value) {
		price = value;
	}

	@OneToMany(mappedBy = "container")
	private List<KebabEntity> kebabWithThisContainerList;
}

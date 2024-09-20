package com.advancia.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="kebab_table")
@NamedQueries({
	@NamedQuery(name = "GetAllKebabsOfUser", query = "SELECT k from KebabEntity k WHERE k.user=:user")
	
})
public class KebabEntity {
	
	@Id	
	@Column(name="kebab_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	public int getId() {
		return id;
	}
	public void setId(int value) {
		id=value;
	}
	
	@Column(name="kebab_name")
	private String name;	
	public String getName() {
		return name;
	}
	public void setName(String value) {
		name=value;
	}
	
	@Column(name="kebab_price")	
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int value) {
		price=value;
	}

	@ManyToOne
	@JoinColumn(name="primary_id")
	private PrimaryIngredientEntity primaryIngredient;
	public PrimaryIngredientEntity getPrimaryIngredient() {
		return primaryIngredient;
	}	
	public void setPrimaryIngredient(PrimaryIngredientEntity value) {
		primaryIngredient=value;
	}

	@ManyToOne
	@JoinColumn(name="container_id")
	private ContainerEntity container;
	public ContainerEntity getContainer() {
		return container;
	}	
	public void setContainer(ContainerEntity value) {
		container=value;
	}
	
	@ManyToMany(targetEntity = SecondaryIngredientEntity.class, fetch=FetchType.EAGER)
	@JoinTable(name = "kebab_secondary_table", 
				joinColumns = { @JoinColumn(name = "kebab_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "secondary_id") })
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

	@ManyToMany(targetEntity = SauceIngredientEntity.class,fetch=FetchType.EAGER)
	@JoinTable(name = "kebab_sauce_table", 
				joinColumns = { @JoinColumn(name = "kebab_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "sauce_id") })
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

	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity value) {
		user=value;
	}
	
}

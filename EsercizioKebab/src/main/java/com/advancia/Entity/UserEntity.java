package com.advancia.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user_table")

@NamedQueries({
		@NamedQuery(name = "FindUserByUsernamePassword", query = "SELECT u FROM UserEntity u WHERE u.username = :username AND u.password=:password"),
		@NamedQuery(name = "GetUserById", query = "SELECT u FROM UserEntity u WHERE u.id = :id"),
		@NamedQuery(name = "GetAllUsers", query = "SELECT u FROM UserEntity u")})

public class UserEntity {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int value) {
		id = value;
	}

	@Column(name = "user_username")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String value) {
		username = value;
	}

	@Column(name = "user_password")
	private String password;

	public String getpassword() {
		return password;
	}

	public void setPassword(String value) {
		password = value;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<KebabEntity> kebabsCreated;

	public List<KebabEntity> getKebabsCreated() {
		return kebabsCreated;
	}

	public void setKebabsCreated() {

	}

}

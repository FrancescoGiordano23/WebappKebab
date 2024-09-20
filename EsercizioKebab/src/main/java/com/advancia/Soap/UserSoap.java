package com.advancia.Soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import com.advancia.Utility.UserServices;
import com.advancia.Entity.UserEntity;

@WebService(serviceName = "UserSoap")
public class UserSoap {

	@WebMethod(operationName = "getUserById")
	public UserEntity getUserId(@WebParam(name = "id") Integer id) throws Exception {
		return UserServices.getUserById(id);
	}

	@WebMethod(operationName = "getAllUsers")
	public List<UserEntity> getAllUsers() throws Exception {
		return UserServices.getAllUsers();
	}

	@WebMethod(operationName = "addUser")
	public void adduser(
			@WebParam(name = "username") @XmlElement(name = "username", required = true, nillable = false) String username,
			@WebParam(name = "password") @XmlElement(name = "password", required = true, nillable = false) String password)
			throws Exception {
		UserServices.createUser(username, password);
	}

	@WebMethod(operationName = "deleteuser")
	public void deleteMuser(@WebParam(name = "id") Integer id) throws Exception {
		UserServices.deleteUserById(id);
	}

}

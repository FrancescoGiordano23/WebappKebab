package com.advancia.soap;

import java.util.List;

import com.advancia.Modal.User;
import com.advancia.Utility.UserServices;

@WebService(serviceName = "userSoap")
public class UserSoap {

	@WebMethod(operationName = "getUserById")
	public User getUserId(@WebParam(name = "id") Integer id) throws Exception {
		return UserServices.getUserById(id);
	}
	@WebMethod(operationName = "getAllUsers")
	public List<User> getAllUsers() throws Exception {
		return UserServices.getAllUsers();
	}

	@WebMethod(operationName = "addUser")
	public void adduser(
	@WebParam(name = "username") @XmlElement(name="username",required=true, nillable=false) String username,
	@WebParam(name = "password") @XmlElement(name="password", required=true, nillable=false) String password,
	    ) throws Exception {
	        UserServices.createUser(username, password);
	}
	
	@WebMethod(operationName = "deleteuser")
    public void deleteMuser(@WebParam(name = "id") Integer id) throws Exception {
        UserServices.deleteUserById(id);
}
	
}

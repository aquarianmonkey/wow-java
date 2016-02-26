package com.berns;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();

	@GET
	@Path("/users")
//	@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}
	
	@GET
	@Path("/greet")
//	@Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.TEXT_XML)
	public Response greet() {
		return Response.status(200).entity("Hey what's up?").build();
	}
	
	@GET
	@Path("/user-{id}")
//	@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") String id) {
		return userDao.getUser(id);
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User createEmployee(User user) {
	    
	    return userDao.createUser(user);
	}

//	@PUT
//	@Path("/update")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Employee updateEmployee(Employee employee) {
//	    // create logic goes here
//	    employee.setName(employee.getName() + "updated");
//	    return employee;
//	}

//	@DELETE
//	@Path("/delete/{empId}")
//	public javax.ws.rs.core.Response deleteEmployee(@PathParam("empId") int empId) throws URISyntaxException {
//	    return javax.ws.rs.core.Response.status(200).entity("Employee with " + empId + "is deleted successfully").build();
//	}
	
	
}

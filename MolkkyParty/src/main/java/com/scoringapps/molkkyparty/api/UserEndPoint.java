package com.scoringapps.molkkyparty.api;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.api.server.spi.config.Api;
import com.scoringapps.molkkyparty.entity.User;
import com.scoringapps.molkkyparty.util.ListItemsWrapper;

@Api(name = "molkkyparty")
@Path("/molkkyparty/v1/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserEndPoint extends AbstractEndPoint {

	// get avec User/{id}
	@GET
	@Path("/{id}")
	public User getUser(@Named("id") @PathParam("id") Long id) {
		return userDao.get(id);
	}

	// get avec User
	@GET
	public ListItemsWrapper<User> listUser() {
		return new ListItemsWrapper(userDao.getAll());
		// return userDao.getAll();
	}

	// post avec User
	@POST
	public User insertUser(User user) {
		System.out.println("insert de fait" + user.name);
		user.nbMatch = 0;
		return userDao.save(user);
	}

	// put avec User
	@PUT
	public User updateUser(User user) {
		return userDao.save(user);
	}

	// delete avec User
	@DELETE
	public User removeUser(@Named("id") Long id) {
		return userDao.getAndDelete(id);
	}
}

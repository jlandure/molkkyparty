package com.scoringapps.molkkyparty.api;

import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.scoringapps.molkkyparty.entity.User;

@Api(name = "molkkyparty")
public class UserEndPoint extends AbstractEndPoint {

	// get avec User/{id}
	public User getUser(@Named("id") Long id) {
		return userDao.get(id);
	}

	// get avec User
	public List<User> listUser() {
		return userDao.getAll();
	}
	
	// post avec User
	public User insertUser(User User) {
		return userDao.save(User);
	}

	// put avec User
	public User updateUser(User User) {
		return userDao.save(User);
	}

	// delete avec User/{1}
	public User removeUser(@Named("id") Long id) {
		return userDao.getAndDelete(id);
	}
}

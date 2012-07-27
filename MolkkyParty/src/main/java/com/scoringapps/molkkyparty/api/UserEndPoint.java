package com.scoringapps.molkkyparty.api;

import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
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
		// return userDao.getAll();
	}

	// post avec User
	public User insertUser(User user) {
		System.out.println("insert de fait" + user.login);
		return userDao.save(user);
	}

	// put avec User
	public User updateUser(User user) {
		System.out.println("update de fait");
		return userDao.save(user);
	}

	// delete avec User
	public User removeUser(@Named("id") Long id) {
		System.out.println("remove de fait");
		return userDao.getAndDelete(id);
	}
}

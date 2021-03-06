package com.scoringapps.molkkyparty.api;

import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.scoringapps.molkkyparty.entity.Group;
import com.scoringapps.molkkyparty.entity.User;

@Api(name = "molkkyparty")
public class GroupEndPoint extends AbstractEndPoint {

	// get avec Group/{id}
	public Group getGroup(@Named("id") Long id) {
		Group group = groupDao.get(id);
		group.users.addAll(userDao.getUsersByGroup(id));
		return group;
	}
	
	// get avec Group/{id}/user
	@ApiMethod(path = "group/{idGroup}/users")
	public List<User> getUsersGroup(@Named("idGroup") Long id) {
		return userDao.getUsersByGroup(id);
	}
	

	// get avec Group
	public List<Group> listGroups() {
		List<Group> groups = groupDao.getAll();
		for (Group group : groups) {
			group.users.addAll(userDao.getUsersByGroup(group.id));
		}
		return groups;
	}

	// post avec Group
	public Group insertGroup(Group Group) {
		return groupDao.save(Group);
	}

	// put avec Group
	public Group updateGroup(Group Group) {
		return groupDao.save(Group);
	}

	// delete avec Group
	public Group removeGroup(@Named("id") Long id) {
		return groupDao.getAndDelete(id);
	}
}

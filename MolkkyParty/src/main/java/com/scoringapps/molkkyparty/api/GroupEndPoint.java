package com.scoringapps.molkkyparty.api;

import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.scoringapps.molkkyparty.entity.Group;

@Api(name = "molkkyparty")
public class GroupEndPoint extends AbstractEndPoint {

	// get avec Group/{id}
	public Group getGroup(@Named("id") Long id) {
		Group group = groupDao.get(id);
		group.users.addAll(userDao.getUsersByGroup(id));
		return group;
	}

	// get avec Group
	public List<Group> listToto() {
		return groupDao.getAll();
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

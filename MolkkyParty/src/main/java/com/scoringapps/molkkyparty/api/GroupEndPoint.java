package com.scoringapps.molkkyparty.api;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.api.server.spi.config.Api;
import com.scoringapps.molkkyparty.entity.Group;
import com.scoringapps.molkkyparty.util.ListItemsWrapper;

@Api(name = "molkkyparty")
@Path("/molkkyparty/v1/group")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GroupEndPoint extends AbstractEndPoint {

	// get avec Group/{id}
	@GET
	@Path("/{id}")
	public Group getGroup(@Named("id") @PathParam("id") Long id) {
		Group group = groupDao.get(id);
		group.users.addAll(userDao.getUsersByGroup(id));
		return group;
	}

	// get avec Group
	@GET
	public ListItemsWrapper<Group> listGroups() {
		List<Group> groups = groupDao.getAll();
		for (Group group : groups) {
			group.users.addAll(userDao.getUsersByGroup(group.id));
		}
		return new ListItemsWrapper(groups);
	}

	// post avec Group
	public Group insertGroup(Group group) {
		return groupDao.save(group);
	}

	// put avec Group
	public Group updateGroup(Group group) {
		return groupDao.save(group);
	}

	// delete avec Group
	public Group removeGroup(@Named("id") Long id) {
		return groupDao.getAndDelete(id);
	}
}

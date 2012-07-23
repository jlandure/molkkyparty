package com.scoringapps.molkkyparty.api;

import com.googlecode.objectify.ObjectifyService;
import com.scoringapps.molkkyparty.dao.GenericDao;
import com.scoringapps.molkkyparty.entity.Group;
import com.scoringapps.molkkyparty.entity.Score;
import com.scoringapps.molkkyparty.entity.User;

public class AbstractEndPoint {

	static {
		ObjectifyService.register(User.class);
		ObjectifyService.register(Group.class);
		ObjectifyService.register(Score.class);
	}

	public static GenericDao<User> userDao = new GenericDao<User>(User.class);
	public static GenericDao<Group> groupDao = new GenericDao<Group>(
			Group.class);
	public static GenericDao<Score> scoreDao = new GenericDao<Score>(
			Score.class);
}

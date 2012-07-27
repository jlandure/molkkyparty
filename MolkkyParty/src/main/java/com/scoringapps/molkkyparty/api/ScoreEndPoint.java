package com.scoringapps.molkkyparty.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.common.collect.Ordering;
import com.scoringapps.molkkyparty.entity.Score;
import com.scoringapps.molkkyparty.entity.User;

@Api(name = "molkkyparty")
@Path("/molkkyparty/v1/classement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ScoreEndPoint extends AbstractEndPoint {

	@ApiMethod(path = "classement")
	@GET
	public Collection<User> getClassement(@Named("idGroup") @QueryParam("idGroup") Long idGroup) {
		List<User> users = userDao.getUsersByGroup(idGroup);
		// List<User> usersOrdered = new ArrayList<User>(users.size());
		HashMap<Long, User> mapUsers = new HashMap<Long, User>();
		for (User user : users) {
			user.nbMatch = 0;
			user.points = 0;
			mapUsers.put(user.id, user);
		}

		List<Score> scores = scoreDao.getScoresByGroup(idGroup);
		for (Score score : scores) {
			this.calculateScore(score, mapUsers);
		}

		return Ordering.natural().sortedCopy(mapUsers.values());

		// Collection<User> usersOrdered = mapUsers.values();

		// return usersOrdered;
	}

	private void calculateScore(Score score, HashMap<Long, User> mapUsers) {
		int i = 1;
		// int nbJoueur = score.idUsers.length;
		for (Long idUser : score.idUsers) {
			mapUsers.get(idUser).nbMatch++;
			int userScore = 4;
			userScore -= score.croix.get(i - 1);
			userScore += i;
			mapUsers.get(idUser).points += userScore;
			i++;
		}

	}
}

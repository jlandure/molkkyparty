package com.scoringapps.molkkyparty.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.scoringapps.molkkyparty.entity.Score;
import com.scoringapps.molkkyparty.entity.User;

@Api(name = "molkkyparty")
public class ScoreEndPoint extends AbstractEndPoint {

	@ApiMethod(path = "classement")
	public List<User> getClassement(@Named("idGroup") Long idGroup) {
		List<User> users = userDao.getUsersByGroup(idGroup);
		// List<User> usersOrdered = new ArrayList<User>(users.size());
		HashMap<Long, User> mapUsers = new HashMap<Long, User>(users.size());
		for (User user : users) {
			mapUsers.put(user.id, user);
		}

		List<Score> scores = scoreDao.getScoresByGroup(idGroup);
		for (Score score : scores) {
			this.calculateScore(score, mapUsers);
		}

		Collection<User> usersOrdered = mapUsers.values();
		// Collections.sort(usersOrdered);

		return users;
	}

	private void calculateScore(Score score, HashMap<Long, User> mapUsers) {
		int i = 0;
		// int nbJoueur = score.idUsers.length;
		for (Long idUser : score.idUsers) {
			mapUsers.get(idUser).nbMatch++;
			int userScore = 4;
			userScore -= score.croix[i];
			userScore += i;
			mapUsers.get(idUser).points += userScore;
			i++;
		}

	}
}

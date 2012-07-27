package com.scoringapps.molkkyparty.api;

import java.util.Arrays;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.scoringapps.molkkyparty.entity.Group;
import com.scoringapps.molkkyparty.entity.Score;
import com.scoringapps.molkkyparty.entity.User;
import com.scoringapps.molkkyparty.util.Message;

@Api(name = "molkkyparty")
@Path("/molkkyparty/v1/populate")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PopulateEndPoint extends AbstractEndPoint {

	@ApiMethod(path = "populate")
	@GET
	public Message getPopulation(@Named("type") @QueryParam("type") String type) {
		Message retour = new Message();
		if ("user".equalsIgnoreCase(type)) {
			User u1 = new User();
			u1.id = 1L;
			u1.name = "Julien Landuré";
			u1.login = "JLE";
			u1.email = "jujujuz@gmail.com";
			u1.nbMatch = 0;
			u1.points = 0;
			u1.idGroup = 1L;
			User u2 = new User();
			u2.id = 2L;
			u2.name = "Guillaume Bouclé";
			u2.login = "GBE";
			u2.email = "gbe@gmail.com";
			u2.nbMatch = 0;
			u2.points = 0;
			u2.idGroup = 1L;
			User u3 = new User();
			u3.id = 3L;
			u3.name = "Rodoplhe Singeot";
			u3.login = "RST";
			u3.email = "rst@gmail.com";
			u3.nbMatch = 0;
			u3.points = 0;
			u3.idGroup = 1L;
			User u4 = new User();
			u4.id = 4L;
			u4.name = "Guillaume Prime";
			u4.login = "GPE";
			u4.email = "gpe@gmail.com";
			u4.nbMatch = 0;
			u4.points = 0;
			u4.idGroup = 1L;
			User u5 = new User();
			u5.id = 5L;
			u5.name = "Maxx";
			u5.login = "MJN";
			u5.email = "max@gmail.com";
			u5.nbMatch = 0;
			u5.points = 0;
			u5.idGroup = 1L;
			userDao.save(u1, u2, u3, u4, u5);
			retour.message = "OK user population";
		} else if ("group".equalsIgnoreCase(type)) {
			Group erw = new Group();
			erw.name = "Euriware";
			erw.id = 1L;
			groupDao.save(erw);
			retour.message = "OK group population";
		} else if ("score".equalsIgnoreCase(type)) {
			Score score1 = new Score();
			score1.idGroup = 1L;
			Long[] user1 = { 2L, 1L, 3L, 5L, 4L };
			// String[] user1 = { "2", "1", "3", "5", "4" };
			// score1.idUsers = user1;
			score1.idUsers = Arrays.asList(user1);
			Integer[] croix1 = { 3, 3, 3, 2, 1 };
			// String[] croix1 = { "3", "3", "3", "2", "1" };
			score1.croix = Arrays.asList(croix1);
			// score1.croix = croix1;
			Integer[] scores1 = { 12, 13, 25, 42, 50 };
			// String[] scores1 = { "12", "13", "25", "42", "50" };
			// score1.scores = scores1;
			score1.scores = Arrays.asList(scores1);
			scoreDao.save(score1);
			retour.message = "OK score population";
		} else {
			retour.message = "ERROR";
		}
		return retour;
	}
}

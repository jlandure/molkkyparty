package com.scoringapps.molkkyparty.api;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.scoringapps.molkkyparty.entity.Group;
import com.scoringapps.molkkyparty.entity.User;
import com.scoringapps.molkkyparty.util.Message;

@Api(name = "molkkyparty")
public class PopulateEndPoint extends AbstractEndPoint {

	@ApiMethod(path = "populate")
	public Message getPopulation(@Named("type") String type) {
		String retour = null;
		if ("user".equalsIgnoreCase(type)) {
			User u1 = new User();
			u1.name = "Julien Landuré";
			u1.login = "JLE";
			u1.email = "jujujuz@gmail.com";
			u1.idGroup = 1L;
			User u2 = new User();
			u2.name = "Guillaume Bouclé";
			u2.login = "GBE";
			u2.email = "gbe@gmail.com";
			u2.idGroup = 1L;
			User u3 = new User();
			u3.name = "Rodoplhe Singeot";
			u3.login = "RST";
			u3.email = "rst@gmail.com";
			u3.idGroup = 1L;
			User u4 = new User();
			u4.name = "Guillaume Prime";
			u4.login = "GPE";
			u4.email = "gpe@gmail.com";
			u4.idGroup = 1L;
			userDao.save(u1, u2, u3, u4);
			retour = "OK user population";
		} else if ("group".equalsIgnoreCase(type)) {
			Group erw = new Group();
			erw.name = "Euriware";
			erw.id = 1L;
			groupDao.save(erw);
			retour = "OK group population";
		} else if ("score".equalsIgnoreCase(type)) {

		}
		return new Message(retour);
	}

}

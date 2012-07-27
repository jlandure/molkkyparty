package com.scoringapps.molkkyparty.entity;

import javax.persistence.Id;
import javax.persistence.Transient;

public class User implements Comparable<User> {

	@Id
	public Long id;

	public String login;

	public String name;

	public String email;

	public Long idGroup;

	@Transient
	public Integer classement;

	@Transient
	public Integer points;

	@Transient
	public Integer nbMatch;

	@Override
	public int compareTo(User o) {
		return this.points.compareTo(o.points);
	}

}

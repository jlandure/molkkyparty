package com.scoringapps.molkkyparty.entity;

import javax.persistence.Id;

public class User {

	@Id
	public Long id;

	public String login;

	public String name;

	public String email;

	public Long idGroup;
}

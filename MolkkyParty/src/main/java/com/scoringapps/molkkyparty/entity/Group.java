package com.scoringapps.molkkyparty.entity;

import java.util.ArrayList;

import javax.persistence.Id;
import javax.persistence.Transient;

public class Group {

	@Id
	public Long id;

	public String name;

	@Transient
	public ArrayList<User> users = new ArrayList<User>();
}

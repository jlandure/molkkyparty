package com.scoringapps.molkkyparty.dao;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Query;
import com.googlecode.objectify.util.DAOBase;
import com.scoringapps.molkkyparty.entity.Score;
import com.scoringapps.molkkyparty.entity.User;

public class GenericDao<T> extends DAOBase {

	public GenericDao(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	protected Class<T> clazz;

	public List<T> getAll() {
		Query<T> q = ofy().query(clazz);
		List<T> elements = new ArrayList<T>();
		for (T element : q) {
			elements.add(element);
		}
		return elements;
	}

	public T get(Long id) {
		return ofy().find(clazz, id);
	}

	public T save(T element) {
		ofy().put(element);
		return element;
	}

	public void save(T... elements) {
		for (T element : elements) {
			ofy().put(element);
		}
	}

	public T getAndDelete(Long id) {
		T element = ofy().find(clazz, id);
		ofy().delete(element);
		return element;
	}

	// SPECIFIC QUERYS !

	public User getUserByLogin(String login) {
		User user = ofy().query(User.class)//
				.filter("login", login)//
				.get();
		return user;
	}

	public List<User> getUsersByGroup(Long idGroup) {
		return ofy().query(User.class)//
				.filter("idGroup", idGroup)//
				.list();
	}

	public List<Score> getScoresByGroup(Long idGroup) {
		return ofy().query(Score.class)//
				.filter("idGroup", idGroup)//
				.list();
	}
}

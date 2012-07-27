package com.scoringapps.molkkyparty.entity;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Unindexed;

public class Score {

	@Id
	public Long id;

	@Unindexed
	public Integer[] scores;

	@Unindexed
	public Integer[] croix;

	@Unindexed
	public Long[] idUsers;

	public Long idGroup;
}

package com.scoringapps.molkkyparty.entity;

import java.util.List;

import javax.persistence.Id;

public class Score {

	@Id
	public Long id;

	// @Unindexed
	public List<Integer> scores;

	// @Unindexed
	public List<Integer> croix;

	// @Unindexed
	public List<Long> idUsers;

	public Long idGroup;
}

package com.scoringapps.molkkyparty.util;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListItemsWrapper<T> {

	@JsonProperty("items")
	public List<T> items;

	public ListItemsWrapper(List<T> items) {
		this.items = items;
	}

}

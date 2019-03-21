package com.tuck.rest;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;


public class Contract {
	
	
	// term length
	// type: contact, service-order, 
	
	protected String id;
	protected String type;
	protected Date startDate;
	protected String term;
	protected double cost;
	
	public Contract(String id, Date startDate, double cost, String term) {
		this.id = id;
		this.startDate = startDate;
		this.cost = cost;
		this.term = term;
	}
	
	// Parent method to be over-written by child contracts
	public JSONObject toJSONStr() throws JSONException {
		return new JSONObject();
	}
	
	
}



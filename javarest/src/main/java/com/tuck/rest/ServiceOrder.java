package com.tuck.rest;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class ServiceOrder extends Contract {
	

	private String nonrecurr;
	private String recurr;
	private String rate = "monthly";
	
	// Given more time, services would be made into its own class
	public ServiceOrder(String id, Date startDate, Double cost, String term, String nonrecurr, String recurr) {
		super(id, startDate, cost, term);
		this.nonrecurr = nonrecurr;
		this.recurr = recurr;
	}

	// Return the Contract details as String
	public String toString() {
		String pattern = "Service Agreement: #%s | Start: $%s | Term: %s | Cost: %s %s | Non-recurring: %s | Recurring: %s";
		return String.format(pattern, id, startDate, term, cost, rate, nonrecurr, recurr);
	}
	
	// Return the Contract details as JSON
	public JSONObject toJSONStr() throws JSONException {
		JSONObject contract = new JSONObject();
		
		contract.put("id", id);
		contract.put("type", "Service Order");
		contract.put("startDate", startDate);
		contract.put("term", term);
		contract.put("cost", cost);
		contract.put("rate", rate);
		contract.put("nonrecurr", nonrecurr);
		contract.put("recurr", recurr);
		
		
		return contract;
	}
}

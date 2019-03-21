package com.tuck.rest;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class ServiceAgreement extends Contract {
	
	private String scope;
	private String summary;
	private String rate = "per hour";
	
	// Given more time, services would be made into its own class
	public ServiceAgreement(String id, Date startDate, Double cost, String term, String scope, String summary) {
		super(id, startDate, cost, term);
		this.scope = scope;
		this.summary = summary;
	}

	// Return the Contract details as String
	public String toString() {
		String pattern = "Service Agreement: #%s | Start: $%s | Term: %s | Cost: %s %s | Summary: %s | Scope: %s";
		return String.format(pattern, id, startDate, term, cost, rate, summary, scope);
	}

	// Return the Contract details as JSON
	public JSONObject toJSONStr() throws JSONException {
		JSONObject contract = new JSONObject();
		
		contract.put("id", id);
		contract.put("type", "Service Agreement");
		contract.put("startDate", startDate);
		contract.put("term", term);
		contract.put("cost", cost);
		contract.put("rate", rate);
		contract.put("summary", summary);
		contract.put("scope", scope);
		
		
		return contract;
	}
}

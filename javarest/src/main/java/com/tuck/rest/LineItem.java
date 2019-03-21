package com.tuck.rest;

import java.util.Date;

import org.json.JSONObject;
import org.json.JSONException;


public class LineItem extends Contract {
	
	private String[] services = {"site 1, 100 Mbps MPLS, 7,400.00",
			"site 2, 100 Mbps MPLS, 7,400.00",
			"site 3, 100 Mbps MPLS, 3,326.00",
			"site 4, 100 Mbps MPLS, 11,670.00"};
	private String rate = "monthly";
	
	// Given more time, services would be made into its own class
	public LineItem(String id, Date startDate, Double cost, String term) {
		super(id, startDate, cost, term);
		
	}

	// Return the Contract details as String
	public String toString() {
		String pattern = "Line-Item Contract: #%s | Start: $%s | Term: %s | Cost: %s %s | Services: %s | %s services";
		String servs = "";
		for (String s : services) servs += s.toString() + ", ";
		return String.format(pattern, id, startDate, term, cost, rate, servs, services.length);
	}

	// Return the Contract details as JSON
	public JSONObject toJSONStr() throws JSONException {
		JSONObject contract = new JSONObject();
		String servs = "";
		for (String s : services) servs += s.toString() + ", ";
		
		contract.put("id", id);
		contract.put("type", "Line-item Contract");
		contract.put("startDate", startDate);
		contract.put("term", term);
		contract.put("cost", cost);
		contract.put("rate", rate);
		contract.put("services", servs);
		contract.put("num_services", services.length);
		
		
		return contract;
	}

}

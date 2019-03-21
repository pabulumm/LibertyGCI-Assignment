package com.tuck.rest;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Invoice {
	
	// id, cost, due date
	private String id;
	private double cost;
	private Date dueDate;
	private boolean paid;
	
	public Invoice(String id, double cost, Date due, boolean paid) {
		this.id = id;
		this.cost = cost;
		this.dueDate = due;
		this.paid = paid;

		// If invoice has been paid -> "Paid"
		// If payment due within a month - > "DUE SOON"
		// If date has passed - > "PAST DUE"
	}

	// Return the Contract details as String
	public String toString() {
		Date d = new Date();
		String status = (paid) ? "Paid" : ((d.after(dueDate)) ? "PAST DUE" : "DUE SOON");
		String pattern = "Invoice: #%s | Cost: $%s | Due: %s | %s";
		return String.format(pattern, id, cost, dueDate, status);
	}
	
	// Return the Contract details as JSON
	public JSONObject toJSONStr() throws JSONException {
		JSONObject invoice = new JSONObject();

		Date d = new Date();
		String status = (paid) ? "Paid" : ((d.after(dueDate)) ? "PAST DUE" : "DUE SOON");
		
		invoice.put("id", id);
		invoice.put("dueDate", dueDate);
		invoice.put("status", status);
		invoice.put("cost", cost);
		
		return invoice;
	}

	
	
}

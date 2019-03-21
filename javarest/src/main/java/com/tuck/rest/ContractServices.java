package com.tuck.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/")
public class ContractServices 
{
	
	private Contract[] contracts = {
			new LineItem("HB-134", new Date(), 52470.00, "2-year term"),
			new ServiceOrder("WT-239", new Date(), 275.00, "3-year term", "Configuration and Testing of Equipment - $3,485.00", "Remote Site VPN - $275.00" ),
			new ServiceAgreement("SA-432", new Date(), 275.00, "3-year term", "This SOW covers the discovery and documentation of..", "Document and evaluate IP Address allocation and usage...")
	};
	private Invoice[] invoices = { new Invoice("335783", 51155.00, new Date(2019, 2, 28), false),
									new Invoice("335783", 275.00, new Date(2019, 4, 15), false)};
	
	// Introduction page
	@GET
	@Produces("text/html")
	public Response getStartingPage() throws JSONException
	{
		String output = "<h1>Contracts & Billing</h1>" +
				"<h3>Contracts</h3>"
				+ "<p>JSON Endpoint : /javarest/json/contracs</p><br/>"
				+ this.getContractsJson() + "<br/>"
				+ "<p>String</p><br/>" + this.getContracts()
				+ "<br/><h3>Invoices</h3>"
				+ "<p>JSON Endpoint : /javarest/json/invoices</p><br/>"
				+ this.getInvoicesJson() + "<br/>"
				+ "<p>String</p><br/>" + this.getInvoices();
		return Response.status(200).entity(output).build();
	}
	
	
	// Retrieve the list of Contracts as String
	@GET
	@Path("/contracts")
	@Produces("text/plain")
	public String getContracts() {
		String str = "";
		for(int i = 0; i < contracts.length; i++) {
			str += contracts[i].toString();
			str += "</br>";
		}
		return str;
	}
	
	// Retrieve the list of Contracts as JSON
	@GET
	@Path("/json/contracts")
	@Produces("application/json")
	public String getContractsJson() throws JSONException {
		JSONObject contractsJSON = new JSONObject();
		for(int i = 0; i < contracts.length; i++) {
			contractsJSON.put("contract-" + Integer.toString(i), contracts[i].toJSONStr());
		}
		return contractsJSON.toString();
	}
	

	// Retrieve the list of Invoices as String
	@GET
	@Path("/invoices")
	@Produces("text/plain")
	public String getInvoices() {
		String str = "";
		for(int i = 0; i < invoices.length; i++) {
			str += invoices[i].toString();
			str += "</br>";
		}
		return str;
	}
	
	// Retrieve the list of Contracts as JSON
	@GET
	@Path("/json/invoices")
	@Produces("application/json")
	public String getInvoicesJson() throws JSONException {
		JSONObject invoicesJSON = new JSONObject();
		for(int i = 0; i < invoices.length; i++) {
			invoicesJSON.put("invoice-" + Integer.toString(i), invoices[i].toJSONStr());
		}
		return invoicesJSON.toString();
	}
	
		
}
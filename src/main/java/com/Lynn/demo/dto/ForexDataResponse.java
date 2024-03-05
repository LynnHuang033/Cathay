package com.Lynn.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForexDataResponse {
	
	@JsonProperty("date")
    private String date;

    @JsonProperty("usd")
    private String usd;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUsd() {
		return usd;
	}

	public void setUsd(String usd) {
		this.usd = usd;
	}
    
    

}

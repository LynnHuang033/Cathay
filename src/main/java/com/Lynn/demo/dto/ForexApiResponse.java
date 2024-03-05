package com.Lynn.demo.dto;

import java.util.List;

import org.antlr.v4.runtime.atn.ErrorInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForexApiResponse {

	@JsonProperty("error")
    private ErrorInfo errorInfo;

    @JsonProperty("currency")
    private List<ForexDataResponse> currency;

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public List<ForexDataResponse> getCurrency() {
		return currency;
	}

	public void setCurrency(List<ForexDataResponse> currency) {
		this.currency = currency;
	}
    
    

}

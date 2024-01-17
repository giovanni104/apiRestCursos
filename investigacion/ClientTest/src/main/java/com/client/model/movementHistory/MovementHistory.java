package com.client.model.movementHistory;

import java.util.ArrayList;

public class MovementHistory {
   
    public ArrayList<Body> body;
    public int statusCodeValue;
    public String statusCode;
    
	public ArrayList<Body> getBody() {
		return body;
	}
	public void setBody(ArrayList<Body> body) {
		this.body = body;
	}
	public int getStatusCodeValue() {
		return statusCodeValue;
	}
	public void setStatusCodeValue(int statusCodeValue) {
		this.statusCodeValue = statusCodeValue;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "MovementHistory [body=" + body + ", statusCodeValue=" + statusCodeValue + ", statusCode=" + statusCode
				+ "]";
	}
    
    
    
    
    
}
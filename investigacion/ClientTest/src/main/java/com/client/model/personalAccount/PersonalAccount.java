package com.client.model.personalAccount;

import java.util.ArrayList;

public class PersonalAccount {
	//public Headers headers;
	public ArrayList<Body> body;
	public int statusCodeValue;
	public String statusCode;

	/*public Headers getHeaders() {
		return headers;
	}

	public void setHeaders(Headers headers) {
		this.headers = headers;
	}*/

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
		return "PersonalAccount [  body=" + body + ", statusCodeValue=" + statusCodeValue
				+ ", statusCode=" + statusCode + "]";
	}

}
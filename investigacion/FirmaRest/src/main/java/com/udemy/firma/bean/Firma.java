package com.udemy.firma.bean;

public class Firma {
 
	private String name;
	private String password;
	private byte[] keydata;

	public Firma() {

	}

	public Firma(String name, String password, byte[] keydata) {

		this.name = name;
		this.password = password;
		this.keydata = keydata;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getKeydata() {
		return keydata;
	}

	public void setKeydata(byte[] keydata) {
		this.keydata = keydata;
	}

 

	 

}

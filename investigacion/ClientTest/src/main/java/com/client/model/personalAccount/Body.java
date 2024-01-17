package com.client.model.personalAccount;

public class Body {
	private String identificacion;
	private String nombrelegal;
	private String cmoneda;
	private String cproducto;
	private String ccuenta;
	private String descripcion;

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombrelegal() {
		return nombrelegal;
	}

	public void setNombrelegal(String nombrelegal) {
		this.nombrelegal = nombrelegal;
	}

	public String getCmoneda() {
		return cmoneda;
	}

	public void setCmoneda(String cmoneda) {
		this.cmoneda = cmoneda;
	}

	public String getCproducto() {
		return cproducto;
	}

	public void setCproducto(String cproducto) {
		this.cproducto = cproducto;
	}

	public String getCcuenta() {
		return ccuenta;
	}

	public void setCcuenta(String ccuenta) {
		this.ccuenta = ccuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Body [identificacion=" + identificacion + ", nombrelegal=" + nombrelegal + ", cmoneda=" + cmoneda
				+ ", cproducto=" + cproducto + ", ccuenta=" + ccuenta + ", descripcion=" + descripcion + "]";
	}



}
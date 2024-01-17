package com.client.model.movementHistory;

public class Body {
	private int stransaccion;
	private String csubsistema;
	private String csubsistema_origen;
	private String ctransaccion_origen;
	private int rubro;
	private Object numerodocumento;
	private Object numerocomprobante;
	private String ccuenta;
    private Object fcontable;
    private Object freal;
    private String cusuario;
    private String ctransaccion;
    private String numerodocumentofinal;
	public int getStransaccion() {
		return stransaccion;
	}
	public void setStransaccion(int stransaccion) {
		this.stransaccion = stransaccion;
	}
	public String getCsubsistema() {
		return csubsistema;
	}
	public void setCsubsistema(String csubsistema) {
		this.csubsistema = csubsistema;
	}
	public String getCsubsistema_origen() {
		return csubsistema_origen;
	}
	public void setCsubsistema_origen(String csubsistema_origen) {
		this.csubsistema_origen = csubsistema_origen;
	}
	public String getCtransaccion_origen() {
		return ctransaccion_origen;
	}
	public void setCtransaccion_origen(String ctransaccion_origen) {
		this.ctransaccion_origen = ctransaccion_origen;
	}
	public int getRubro() {
		return rubro;
	}
	public void setRubro(int rubro) {
		this.rubro = rubro;
	}
	public Object getNumerodocumento() {
		return numerodocumento;
	}
	public void setNumerodocumento(Object numerodocumento) {
		this.numerodocumento = numerodocumento;
	}
	public Object getNumerocomprobante() {
		return numerocomprobante;
	}
	public void setNumerocomprobante(Object numerocomprobante) {
		this.numerocomprobante = numerocomprobante;
	}
	public String getCcuenta() {
		return ccuenta;
	}
	public void setCcuenta(String ccuenta) {
		this.ccuenta = ccuenta;
	}
	public Object getFcontable() {
		return fcontable;
	}
	public void setFcontable(Object fcontable) {
		this.fcontable = fcontable;
	}
	public Object getFreal() {
		return freal;
	}
	public void setFreal(Object freal) {
		this.freal = freal;
	}
	public String getCusuario() {
		return cusuario;
	}
	public void setCusuario(String cusuario) {
		this.cusuario = cusuario;
	}
	public String getCtransaccion() {
		return ctransaccion;
	}
	public void setCtransaccion(String ctransaccion) {
		this.ctransaccion = ctransaccion;
	}
	public String getNumerodocumentofinal() {
		return numerodocumentofinal;
	}
	public void setNumerodocumentofinal(String numerodocumentofinal) {
		this.numerodocumentofinal = numerodocumentofinal;
	}
	@Override
	public String toString() {
		return "Body [stransaccion=" + stransaccion + ", csubsistema=" + csubsistema + ", csubsistema_origen="
				+ csubsistema_origen + ", ctransaccion_origen=" + ctransaccion_origen + ", rubro=" + rubro
				+ ", numerodocumento=" + numerodocumento + ", numerocomprobante=" + numerocomprobante + ", ccuenta="
				+ ccuenta + ", fcontable=" + fcontable + ", freal=" + freal + ", cusuario=" + cusuario
				+ ", ctransaccion=" + ctransaccion + ", numerodocumentofinal=" + numerodocumentofinal + "]";
	}
    
    
    
    
    
    
    
    
}

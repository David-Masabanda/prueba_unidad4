package com.uce.edu.demo.repository.modelo;

public class ListaProductos {
	
	private String codigoBarras;
	private Integer cantidad;
	
	public ListaProductos(String codigo, Integer cantidad) {
		this.codigoBarras=codigo;
		this.cantidad=cantidad;
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}

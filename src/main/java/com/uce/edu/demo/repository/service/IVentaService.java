package com.uce.edu.demo.repository.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.ListaProductos;
import com.uce.edu.demo.repository.modelo.Venta;

public interface IVentaService {

	public void insertarVenta(Venta v);
	public void procesarVenta(List<ListaProductos> productos, String cedula, String numero);
}

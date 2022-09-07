package com.uce.edu.demo.repository.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.ListaProductos;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ReporteVentas;

public interface IGestorSupermaxiService {

	public void insertarProducto(Producto p);
	
	public void realizarVenta(List<ListaProductos> productos, String cedula, String numero);

	public void consultarStock(String codigo);
	
	public List<ReporteVentas> reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad);
	
}

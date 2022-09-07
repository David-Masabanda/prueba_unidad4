package com.uce.edu.demo.repository.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.CantidadStock;
import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoService {
	public void ingresarProducto(Producto p);
	public Producto buscarProducto(String codigo);
	public void actualizarProducto(Producto p);
	
	public CantidadStock consultarStock(String codigo);
	
	public List<Producto> buscarTodos();
}

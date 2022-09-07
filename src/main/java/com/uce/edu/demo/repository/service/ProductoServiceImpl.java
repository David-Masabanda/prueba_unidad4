package com.uce.edu.demo.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.CantidadStock;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	public void ingresarProducto(Producto p) {
		this.productoRepository.ingresarProducto(p);
		
	}

	@Override
	public Producto buscarProducto(String codigo) {
		// TODO Auto-generated method stub
		return this.buscarProducto(codigo);
	}

	@Override
	public void actualizarProducto(Producto p) {
		// TODO Auto-generated method stub
		this.productoRepository.actualizarProducto(p);
	}

	@Override
	public CantidadStock consultarStock(String codigo) {
		// TODO Auto-generated method stub
		return this.productoRepository.consultarStock(codigo);
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return this.productoRepository.buscarTodos();
	}
	
}

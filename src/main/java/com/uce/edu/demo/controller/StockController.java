package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.CantidadStock;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.service.IProductoService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private IProductoService productoService;

	//Get-Buscar
	/*
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo){
		List<Producto> lista= this.productoService.buscarTodos();
		modelo.addAttribute("productos",lista);
		return "vistaListaProductos";
	}*/
	
	@GetMapping("/buscar")
	public String nuevaPersona(Producto producto) {
		return "vistaBuscarStock";
	}
	
	@GetMapping("/buscarUno/{codProducto}")
	public String buscarPersona(@PathVariable("codProducto") String codigo, Model modelo) {
		System.out.println("El ID: "+ codigo);
		CantidadStock prod= this.productoService.consultarStock(codigo);
		modelo.addAttribute("productost", prod);
		return "vistaStock";
	}
	
}

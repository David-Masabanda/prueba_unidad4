package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	//Get-Buscar
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo){
		List<Producto> lista= this.productoService.buscarTodos();
		modelo.addAttribute("productos",lista);
		return "vistaListaProductos";
	}
	
	//Insertar
	@GetMapping("/nuevoProducto")
	public String nuevaPersona(Producto producto) {
		return "vistaNuevoProducto";
	}
	
	@PostMapping("/insertar")
	public String insertarPersona(Producto producto) {
		this.productoService.ingresarProducto(producto);
		return "redirect:/productos/buscar";
	}
}

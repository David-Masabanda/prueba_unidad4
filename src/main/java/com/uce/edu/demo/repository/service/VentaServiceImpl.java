package com.uce.edu.demo.repository.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.ListaProductos;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepository ventaRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	public void insertarVenta(Venta v) {
		this.ventaRepository.insertarVenta(v);
		
	}

	@Override
	public void procesarVenta(List<ListaProductos> productos, String cedula, String numero) {
		
		List<DetalleVenta> detalles = new ArrayList<>();
		BigDecimal totalVenta=new BigDecimal(0);
		for(ListaProductos lista:productos) {
			
			Producto producto=this.productoRepository.buscarProducto(lista.getCodigoBarras());
			DetalleVenta detalle=new DetalleVenta();
			detalle.setPrecioUnitario(producto.getPrecio());
				
			if(producto.getStock()==0) {
				throw new RuntimeException();
			}
			if(lista.getCantidad()>=producto.getStock()) {	
				detalle.setCantidad(producto.getStock());	
			}else {
				detalle.setCantidad(lista.getCantidad());
			}
			BigDecimal total= producto.getPrecio().multiply(new BigDecimal(lista.getCantidad())); 
			totalVenta=totalVenta.add(total);
			
			detalle.setSubtotal(total);
			detalle.setProducto(producto);
			detalles.add(detalle);
		}
		Venta venta=new Venta();
		venta.setNumero(numero);
		venta.setFecha(LocalDateTime.now());
		venta.setCedulaCliente(cedula);
		venta.setDetalles(detalles);
		venta.setTotalVenta(totalVenta);
		
		this.ventaRepository.insertarVenta(venta);
		
	}

}

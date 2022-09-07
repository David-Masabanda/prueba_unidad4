package com.uce.edu.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.ReporteVentas;
import com.uce.edu.demo.repository.service.GestorSupermaxiServiceImpl;
import com.uce.edu.demo.repository.service.IProductoService;

@SpringBootApplication
public class PruebaUnidad4JmApplication implements CommandLineRunner{

	@Autowired
	private GestorSupermaxiServiceImpl gestorService;
	
	@Autowired
	private IProductoService productoService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad4JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Producto p=new Producto();
		p.setCodigoBarras("A001");
		p.setNombre("Avena");
		p.setCategoria("Cereales");
		p.setStock(3);
		p.setPrecio(new BigDecimal(3.1));
		
		this.gestorService.insertarProducto(p);
		*/
		
		//CantidadStock a= this.productoService.consultarStock("A005");
		//System.out.println(a);
		
		List<ReporteVentas>repo=this.gestorService.reporteVentas(LocalDateTime.of(2022, 2, 11, 0, 0), "Cereales", 1);
		for(ReporteVentas item: repo) {
			System.out.println(item);
		}
	}

}

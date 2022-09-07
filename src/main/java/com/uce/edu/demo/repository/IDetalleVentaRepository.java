package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.ReporteVentas;

public interface IDetalleVentaRepository {

	public List<DetalleVenta> reporteFecha(LocalDateTime fecha);
	public ReporteVentas reporte(String categoria, Integer cantidad, Integer id);

	
}

package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.ReporteVentas;

@Repository
@Transactional
public class DetalleRepositoryImpl implements IDetalleVentaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<DetalleVenta> reporteFecha(LocalDateTime fecha) {
		TypedQuery<DetalleVenta> myQuery=this.entityManager.createQuery(
				"SELECT d FROM DetalleVenta d JOIN d.venta v WHERE v.fecha= : datoFecha", 
				DetalleVenta.class);
		myQuery.setParameter("datoFecha", fecha);
		return myQuery.getResultList();
	}

	@Override
	public ReporteVentas reporte(String categoria, Integer cantidad, Integer id) {
		TypedQuery<ReporteVentas> myQuery=this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.ReporteVentas(p.codigoBarras, p.nombre, d.cantidad, d.precioUnitario, d.subtotal) "
				+ "FROM DetalleVenta d JOIN d.producto p WHERE p.categoria= : datoCategoria AND d.cantidad= :datoCantidad AND d.id=:datoId", 
				ReporteVentas.class);
		myQuery.setParameter("datoCategoria", categoria);
		myQuery.setParameter("datoCantidad", cantidad);
		myQuery.setParameter("datoId", id);
		return myQuery.getSingleResult();
	}

}

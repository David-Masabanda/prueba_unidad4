package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CantidadStock;
import com.uce.edu.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void ingresarProducto(Producto p) {
		this.entityManager.persist(p);
	}

	@Override
	public void actualizarProducto(Producto p) {
		this.entityManager.merge(p);
	}
	
	@Override
	public Producto buscarProducto(String codigo) {
		TypedQuery<Producto> myQuery=this.entityManager.createQuery(
				"SELECT p FROM Producto p WHERE p.codigoBarras=:datoCodigo",
				Producto.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public CantidadStock consultarStock(String codigo) {
		TypedQuery<CantidadStock> myQuery=this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.CantidadStock(p.codigoBarras, p.nombre, p.stock) FROM Producto p WHERE p.codigoBarras= :datoCodigo",
				CantidadStock.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Producto> buscarTodos() {
		TypedQuery<Producto> myQuery=this.entityManager.createQuery(
				"SELECT p FROM Producto p",
				Producto.class);
		return myQuery.getResultList();
	}


}

package com.alex.spring.boot.backend.apirest.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alex.spring.boot.backend.apirest.models.entity.Producto;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Long>{
	
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto>  findByNombre(String name);

	public List<Producto>  findByNombreContainingIgnoreCase(String nombre);
	
	public List<Producto>  findByNombreStartingWithIgnoreCase(String nombre);
}

package com.alex.spring.boot.backend.apirest.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alex.spring.boot.backend.apirest.models.entity.Ciudad;
import com.alex.spring.boot.backend.apirest.models.entity.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Long>{
	
	@Query("from Ciudad")
	public List<Ciudad> findAllCiudades();

}

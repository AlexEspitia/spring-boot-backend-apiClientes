package com.alex.spring.boot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.spring.boot.backend.apirest.models.entity.Factura;
import com.alex.spring.boot.backend.apirest.models.entity.Producto;
import com.alex.spring.boot.backend.apirest.models.repository.IFacturaRepo;
import com.alex.spring.boot.backend.apirest.models.repository.IProductoRepo;

@Service
public class FacturaService implements IFacturaService{
	
	@Autowired
	private IFacturaRepo facturaRepo;
	
	@Autowired
	private IProductoRepo productoRepo;

	@Override
	@Transactional(readOnly = true)
	public Factura findById(Long id) {
		return facturaRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura save(Factura factura) {
		return facturaRepo.save(factura);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		facturaRepo.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findProductoByNombre(String name) {
		return productoRepo.findByNombre(name);
	}

}

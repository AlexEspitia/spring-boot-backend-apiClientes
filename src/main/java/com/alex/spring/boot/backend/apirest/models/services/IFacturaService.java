package com.alex.spring.boot.backend.apirest.models.services;

import java.util.List;

import com.alex.spring.boot.backend.apirest.models.entity.Factura;
import com.alex.spring.boot.backend.apirest.models.entity.Producto;


public interface IFacturaService {
	
	public Factura findById(Long id);	
	
	public Factura save(Factura factura);
	
	public void delete(Long id);
	
	public List<Producto>  findProductoByNombre(String name);
	
	

}

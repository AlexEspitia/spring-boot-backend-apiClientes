package com.alex.spring.boot.backend.apirest.controllers;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alex.spring.boot.backend.apirest.models.entity.Factura;
import com.alex.spring.boot.backend.apirest.models.entity.Producto;
import com.alex.spring.boot.backend.apirest.models.services.IFacturaService;

@CrossOrigin(origins = {"http://localhost:4200","*"} )
@RestController
@RequestMapping("/api")
public class FacturaRestControllers{
	
	@Autowired
	private IFacturaService facturaService;
	
	private final Logger log = LoggerFactory.getLogger(ClienteRestController.class);
	
	/**
     * @return metodo para buscar factura por id
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/facturas/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable("id") Long id ){
        return new ResponseEntity<Factura>(facturaService.findById(id), HttpStatus.OK);
    }
	/**
     * @return metodo para eliminar cliente
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
	       facturaService.delete(id);
	    }
	/**
     * @return metodo para buscar productos por nombre
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-02-01
     */
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/facturas/productos/{name}")
	@ResponseStatus(HttpStatus.OK)
    public List<Producto> getProductoByName(@PathVariable("name") String name ){
        return facturaService.findProductoByNombre(name);
    }
	/**
     * @return metodo para crear facturas
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/facturas")
    public ResponseEntity<Factura> postFactura(@RequestBody Factura factura ){
        return new ResponseEntity<Factura>(facturaService.save(factura), HttpStatus.CREATED);
    }

}

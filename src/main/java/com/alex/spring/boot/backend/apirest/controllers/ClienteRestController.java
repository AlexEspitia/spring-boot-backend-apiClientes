package com.alex.spring.boot.backend.apirest.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.alex.spring.boot.backend.apirest.models.entity.Ciudad;
import com.alex.spring.boot.backend.apirest.models.entity.Cliente;
import com.alex.spring.boot.backend.apirest.models.services.IClienteService;
import com.alex.spring.boot.backend.apirest.models.services.IUploadFileService;


@CrossOrigin(origins = {"http://localhost:4200", "*"} )
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IUploadFileService uploadService;
	
	//private final Logger log = LoggerFactory.getLogger(ClienteRestController.class);
	
	/**
     * @return metodo para ver lista clientes
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}
	
	/**
     * @return metodo para ver paginado
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@GetMapping("/clientes/page/{page}")
	public Page<Cliente> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return clienteService.findAll(pageable);
	}
	
	/**
     * @return metodo para buscar cliente por id
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?>  Show(@PathVariable Long id) {
		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();
		try {
			cliente = clienteService.findById(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos ");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (cliente == null) {
			response.put("mensaje", "El cliente id: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK) ;
	}
	
	/**
     * @return metodo para crear cliente
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Validated @RequestBody Cliente cliente, BindingResult result) {
		Cliente clienteNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo ' "+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			clienteNew = clienteService.save(cliente);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos ");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido creado con éxito");
		response.put("error",clienteNew );
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	/**
     * @return metodo para actualizar cliente
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {
		
		Cliente clienteActual = clienteService.findById(id);
		
		Cliente clienteUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo ' "+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (cliente == null) {
			response.put("mensaje", "Error: no se pudo editar, el cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setEmail(cliente.getEmail());
		clienteActual.setFecha(cliente.getFecha());
		clienteActual.setCiudad(cliente.getCiudad());
		
		clienteUpdated = clienteService.save(clienteActual);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos ");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido Actualizado con éxito");
		response.put("Cliente",clienteUpdated );
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
	/**
     * @return metodo para eliminar cliente
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			
			Cliente cliente = clienteService.findById(id);
			String nombreFotoAnterior = cliente.getFoto();
			
			//eliminar archivo al cliente
			uploadService.eliminar(nombreFotoAnterior);
			//  eliminar el cliente
			clienteService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el cliente en la base de datos ");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Cliente eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK); 
	}
	/**
     * @return metodo para subir archivos
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/clientes/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Cliente cliente = clienteService.findById(id);
		if(!archivo.isEmpty()) {
			
			String nombreArchivo = null; 
			
			try {
				nombreArchivo = uploadService.guardar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del cliente ");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior = cliente.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);
			
			cliente.setFoto(nombreArchivo);
			
			clienteService.save(cliente);
			
			response.put("cliente", cliente);
			response.put("mensaje", "Has subido correctamente el archivo "+ nombreArchivo);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				
	}
	/**
     * @return metodo para descargar la imagen
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		
		Resource recurso = null;
		
		try {
			recurso = uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + recurso.getFilename()+"\"");
;
		return new ResponseEntity<Resource>(recurso,cabecera, HttpStatus.OK);
	}
	/**
     * @return metodo para ver lista ciudades
     * @author Alexander Espitia <paespitia6@outlook.com> 2022-12-01
     */
	@GetMapping("/clientes/ciudades")
	public List<Ciudad> getCiudades(){
		return clienteService.findAllCiudades();
	}
	
}

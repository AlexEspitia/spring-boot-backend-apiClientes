package com.alex.spring.boot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.spring.boot.backend.apirest.models.entity.Ciudad;
import com.alex.spring.boot.backend.apirest.models.entity.Cliente;
import com.alex.spring.boot.backend.apirest.models.repository.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo clienteRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepo.findAll();
	}
	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteRepo.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		clienteRepo.deleteById(id); 
		
	}
	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findAllCiudades() {
		return clienteRepo.findAllCiudades();
	}
	
}

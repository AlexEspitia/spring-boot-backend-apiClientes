package com.alex.spring.boot.backend.apirest.models.services;

import com.alex.spring.boot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);
}

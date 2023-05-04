package com.alex.spring.boot.backend.apirest.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.alex.spring.boot.backend.apirest.models.entity.Usuario;
import com.alex.spring.boot.backend.apirest.models.repository.IUsuarioRepo;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioRepo usuarioRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findByUsername(username);
		
		if (usuario == null) {
            logger.error("Error en el login: no existe el usuario '" + username + "' en el sistema!");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '" + username + "' en el sistema!");
        }
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(true), true,true, true, authorities);
	}
	
	@Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return usuarioRepo.findByUsername(username);
    }

    //listar by id
    public Usuario getUsuarioById(Long id) {
        return usuarioRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("usuario no encontrado con el id %d ", id)));
    }

}

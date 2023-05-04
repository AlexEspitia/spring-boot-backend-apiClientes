package com.alex.spring.boot.backend.apirest.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alex.spring.boot.backend.apirest.models.entity.Usuario;


@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
	
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsername2(String username);

}

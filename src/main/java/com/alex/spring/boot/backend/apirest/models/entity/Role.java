package com.alex.spring.boot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	
	@Column(unique = true, length = 20 )
	private String nombre;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

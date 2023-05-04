package com.alex.spring.boot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	private String nombre;
	
	private Double precio;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

	public Producto() {
		super();
	}

	public Producto(Long id, String nombre, Double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
}

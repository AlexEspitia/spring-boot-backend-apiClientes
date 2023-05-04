package com.alex.spring.boot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
	/**
	 * Se crea variable serializable
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	
	@NotEmpty
	@Size(min=4, max=12)
	@Column(nullable = false )
	private String nombre;
	
	
	@NotEmpty
	private String apellido;
	

	@NotEmpty(message ="No puede estar vacio")
	@Email
	@Column(nullable = false, unique = true )
	private String email;
	
	@NonNull
	@Column(name ="fecha" )
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	private String foto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	@JoinColumn(name = "ciudad_id", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handller"})
	private Ciudad ciudad;
	
	@JsonIgnoreProperties(value={"cliente","hibernateLazyInitializer","handller"}, allowSetters =true )
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Factura> facturas;

	
	public Cliente() {
		this.facturas = new ArrayList<>();
	}

	public Cliente(Long id, String nombre, String apellido, String email, Date fecha, String foto,
			Ciudad ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fecha = fecha;
		this.foto = foto;
		this.ciudad = ciudad;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

}

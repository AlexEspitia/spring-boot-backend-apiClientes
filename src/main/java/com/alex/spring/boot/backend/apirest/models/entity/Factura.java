package com.alex.spring.boot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "facturas")
public class Factura implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	private String descripcion;
	
	private String observacion;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@JsonIgnoreProperties(value={"facturas","hibernateLazyInitializer","handller"}, allowSetters=true )
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handller"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "factura_id", referencedColumnName = "id")
	private List<ItemFactura> items;
	
	
	public Factura() {
		items = new ArrayList<>();
	}

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	public Double getTotal() {
		Double total = 0.00;
		for (ItemFactura item: items) {
			total += item.getImporte() ;
		}
		return total;
	}

	private static final long serialVersionUID = 1L;

}

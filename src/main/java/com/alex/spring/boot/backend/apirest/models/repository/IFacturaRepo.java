package com.alex.spring.boot.backend.apirest.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.spring.boot.backend.apirest.models.entity.Factura;

@Repository
public interface IFacturaRepo extends JpaRepository<Factura,Long>{

}

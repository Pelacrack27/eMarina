package com.gestion.emarina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.emarina.domain.Pago;

public interface PagoRepository extends JpaRepository<Pago, String>  {

	
	public List <Pago> findAll();
	
}

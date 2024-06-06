package com.gestion.emarina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.emarina.domain.Barco;
import com.gestion.emarina.domain.Propietario;



public interface PropietarioRepository extends JpaRepository<Propietario, String> {

	
	public List <Propietario> findAll();
	
	public Propietario findByIdPropietario(String id);
	 
	  
	 public void deleteById(String id);
}

package com.gestion.emarina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.emarina.domain.Barco;
import com.gestion.emarina.domain.Propietario;


public interface BarcoRepository extends JpaRepository<Barco, String> {

	
	public List <Barco> findAll();
	
	public List<Barco> findByIdpropietario(Propietario propietario);
	
	 public void deleteById(String id);
	 
		public Barco findByIdBarco(String id);
	 
}

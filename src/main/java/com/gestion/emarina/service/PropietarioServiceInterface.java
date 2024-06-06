package com.gestion.emarina.service;

import java.util.List;

import com.gestion.emarina.domain.Barco;
import com.gestion.emarina.domain.Propietario;


public interface PropietarioServiceInterface {

	
	public List <Propietario> findAll();
	
	  public Propietario create(Propietario propietario);
	
	  
	  public void delete(String id);
	  
	  public Propietario update(Propietario propietario);

	public  Propietario findByIdPropietario(String id);
}

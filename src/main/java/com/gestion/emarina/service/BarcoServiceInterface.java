package com.gestion.emarina.service;

import java.util.List;

import com.gestion.emarina.domain.Barco;
import com.gestion.emarina.domain.Propietario;

public interface BarcoServiceInterface {

	
	public List <Barco> findAll();
	
	  public Barco create(Barco propietario);
	
	  
	  public Barco update(Barco propietario);
	  
	  
	  public void delete(String id);
	  
	  public  Barco findByIdBarco(String id);
	  
	public  List<Barco> findByIdpropietario(Propietario propietario);
}

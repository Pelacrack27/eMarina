package com.gestion.emarina.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.emarina.domain.Barco;
import com.gestion.emarina.domain.Propietario;
import com.gestion.emarina.repository.BarcoRepository;
import com.gestion.emarina.service.BarcoServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class BarcoServiceImpl implements BarcoServiceInterface{

	
	 @Autowired
	 BarcoRepository barcoodao;
	 
	 
	 @Override
	 public List<Barco> findAll() {
	        List<Barco> lista = barcoodao.findAll();
	        return lista;
	    }
	 
	 @Override
	   public Barco create(Barco objeto) {
		    
		  
		    return barcoodao.save(objeto);
	    }
	 
	
	   @Override
	    public Barco findByIdBarco(String d) {
	        return barcoodao.findByIdBarco(d);
	    }
	   
		 @Override
		 @Transactional  
		   public Barco update(Barco barco) {
			    // Verificar si el propietario existe en la base de datos
			    Optional<Barco> barcooExistente = barcoodao.findById(barco.getIdBarco());
			    
			    if (barcooExistente.isPresent()) {
			        // Propietario existente encontrado, actualizar sus atributos
			    	Barco barcoEnBaseDeDatos = barcooExistente.get();
			        
			        // Actualizar los atributos del propietario existente
			    	barcoEnBaseDeDatos.setMatricula(barco.getMatricula());
			    	barcoEnBaseDeDatos.setPropulsion(barco.getPropulsion());
			    	barcoEnBaseDeDatos.setEslora(barco.getEslora());
			    	barcoEnBaseDeDatos.setManga(barco.getManga());
			    	barcoEnBaseDeDatos.setIscatamaran(barco.isIscatamaran());
			    	barcoEnBaseDeDatos.setNacionalidad(barco.getNacionalidad());
			    	barcoEnBaseDeDatos.setOcupantes(barco.getOcupantes());
			    	barcoEnBaseDeDatos.setTelefono_armador(barco.getTelefono_armador());
			    	barcoEnBaseDeDatos.setIdpropietario(barco.getIdpropietario());
			        
			        // Guardar los cambios en la base de datos
			        return barcoodao.save(barcoEnBaseDeDatos);
			    } else {
			        
			        throw new IllegalArgumentException("Propietario no encontrado con ID: " + barco.getIdBarco());
			    }
			}

		 
		 
	   @Override
	    public List<Barco> findByIdpropietario(Propietario propietario) {
	        return barcoodao.findByIdpropietario(propietario);
	    }
	  
	   
	   @Override
	    public void delete(String id) {
		   barcoodao.deleteById(id);
	    }
}

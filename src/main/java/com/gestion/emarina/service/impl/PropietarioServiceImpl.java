package com.gestion.emarina.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.emarina.domain.Barco;
import com.gestion.emarina.domain.Propietario;
import com.gestion.emarina.repository.BarcoRepository;
import com.gestion.emarina.repository.PropietarioRepository;
import com.gestion.emarina.service.PropietarioServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class PropietarioServiceImpl implements PropietarioServiceInterface {

	
	 @Autowired
	 PropietarioRepository propietariodao;
	 
	 @Autowired
	    private BarcoRepository barcodao;
	 
	 public List<Propietario> findAll() {
	        List<Propietario> lista = propietariodao.findAll();
	        return lista;
	    }
	 
	 
	
	 
	 
	   public Propietario create(Propietario objeto) {
		  
		    return propietariodao.save(objeto);
	    }
	 
	 
	   
	  
	   @Override
	    public Propietario findByIdPropietario(String d) {
	        return propietariodao.findByIdPropietario(d);
	    }
	  
	 @Override
	 @Transactional  
	   public Propietario update(Propietario propietario) {
		    // Verificar si el propietario existe en la base de datos
		    Optional<Propietario> propietarioExistente = propietariodao.findById(propietario.getIdPropietario());
		    
		    if (propietarioExistente.isPresent()) {
		        // Propietario existente encontrado, actualizar sus atributos
		        Propietario propietarioEnBaseDeDatos = propietarioExistente.get();
		        
		        // Actualizar los atributos del propietario existente
		        propietarioEnBaseDeDatos.setIdentificacion(propietario.getIdentificacion());
		        propietarioEnBaseDeDatos.setNombre(propietario.getNombre());
		        propietarioEnBaseDeDatos.setApellidos(propietario.getApellidos());
		        propietarioEnBaseDeDatos.setFnacimiento(propietario.getFnacimiento());
		        propietarioEnBaseDeDatos.setTelefono(propietario.getTelefono());
		        propietarioEnBaseDeDatos.setNacionalidad(propietario.getNacionalidad());
		        
		        // Guardar los cambios en la base de datos
		        return propietariodao.save(propietarioEnBaseDeDatos);
		    } else {
		        // Propietario no encontrado, lanzar una excepción
		        throw new IllegalArgumentException("Propietario no encontrado con ID: " + propietario.getIdPropietario());
		    }
		}

	   
	   public void delete(String id) {
		   Optional<Propietario> propietarioOptional = propietariodao.findById(id);
		    if (propietarioOptional.isPresent()) {
		        Propietario propietario = propietarioOptional.get();
		        // Verificar si el propietario tiene barcos asociados
		        List<Barco> barcosAsociados = barcodao.findByIdpropietario(propietario);
		        if (barcosAsociados.isEmpty()) {
		            // Si no tiene barcos asociados, eliminar el propietario
		            propietariodao.deleteById(propietario.getIdPropietario());
		        } else {
		            // Si tiene barcos asociados, lanzar una excepción o manejarlo de otra manera
		            throw new IllegalStateException("No se puede eliminar el propietario porque tiene barcos asociados.");
		        }
		    } else {
		        // Si no se encuentra el propietario con el ID proporcionado, lanzar una excepción
		        throw new IllegalArgumentException("Propietario no encontrado con ID: " + id);
		    }
	    }
	   
}

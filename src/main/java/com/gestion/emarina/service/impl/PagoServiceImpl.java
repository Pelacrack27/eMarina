package com.gestion.emarina.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.emarina.domain.Pago;
import com.gestion.emarina.repository.PagoRepository;
import com.gestion.emarina.service.PagoServiceInterface;

@Service
public class PagoServiceImpl  implements PagoServiceInterface{

	
	 @Autowired
	 PagoRepository pagodao;

	 
	 public List<Pago> findAll() {
	        List<Pago> lista = pagodao.findAll();
	        return lista;
	    }
	 
}

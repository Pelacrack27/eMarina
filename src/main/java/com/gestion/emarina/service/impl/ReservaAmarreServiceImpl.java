package com.gestion.emarina.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.emarina.domain.ReservaAmarre;
import com.gestion.emarina.repository.ReservaAmarreRepository;
import com.gestion.emarina.service.ReservaAmarreServiceInterface;

@Service
public class ReservaAmarreServiceImpl implements ReservaAmarreServiceInterface{

	
	 @Autowired
	 ReservaAmarreRepository reservamarredao;

	 
	 public List<ReservaAmarre> findAll() {
	        List<ReservaAmarre> lista = reservamarredao.findAll();
	        return lista;
	    }
}

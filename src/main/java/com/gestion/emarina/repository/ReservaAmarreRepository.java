package com.gestion.emarina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.emarina.domain.Barco;
import com.gestion.emarina.domain.ReservaAmarre;

public interface ReservaAmarreRepository extends JpaRepository<ReservaAmarre, String> {

	
	public List <ReservaAmarre> findAll();
	
}

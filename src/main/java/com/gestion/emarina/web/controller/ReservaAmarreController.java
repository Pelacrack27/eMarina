package com.gestion.emarina.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.emarina.domain.ReservaAmarre;
import com.gestion.emarina.service.ReservaAmarreServiceInterface;

@Controller
@RequestMapping("/emarina/reservamarre")
public class ReservaAmarreController {

	  @Autowired
	    private ReservaAmarreServiceInterface reservamarreService;
	  
	
	  @GetMapping("/consultar")
	    public ModelAndView obtenerListaBarcos() {
	        ModelAndView modelAndView = new ModelAndView("reservamarre/consultarReservaAmarre"); 
	        List<ReservaAmarre> reservasamarres = reservamarreService.findAll();
	        modelAndView.addObject("reservasamarres", reservasamarres);
	        return modelAndView;
	    }
	
}

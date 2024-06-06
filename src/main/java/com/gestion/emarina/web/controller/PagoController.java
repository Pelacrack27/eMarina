package com.gestion.emarina.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.emarina.domain.Pago;
import com.gestion.emarina.service.PagoServiceInterface;

@Controller
@RequestMapping("/emarina/pago")
public class PagoController {

	
	 @Autowired
	    private PagoServiceInterface pagoService;
	  
	
	  @GetMapping("/consultar")
	    public ModelAndView obtenerListaFacturas() {
	        ModelAndView modelAndView = new ModelAndView("pago/consultarPago"); 
	        List<Pago> pagos = pagoService.findAll();
	        modelAndView.addObject("pagos", pagos);
	        return modelAndView;
	    }
	  
}

package com.gestion.emarina.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.emarina.domain.Barco;
import com.gestion.emarina.domain.Propietario;
import com.gestion.emarina.service.BarcoServiceInterface;
import com.gestion.emarina.service.PropietarioServiceInterface;

@Controller
@RequestMapping("/emarina/barco")
public class BarcoController {

	
	  @Autowired
	    private BarcoServiceInterface barcoService;
	  
	  @Autowired
	    private PropietarioServiceInterface propietarioService;
	  
	  @GetMapping("/consultar")
	    public ModelAndView obtenerListaBarcos() {
	        ModelAndView modelAndView = new ModelAndView("barco/consultarBarco"); 
	        List<Barco> barcos = barcoService.findAll();
	        modelAndView.addObject("barcos", barcos);
	        return modelAndView;
	    }
	
	
	  @GetMapping("/inicioCrear")
	  public ModelAndView inicioCrear() {
	      ModelAndView modelAndView = new ModelAndView("barco/crearBarco");
	      List<Propietario> propietarios = propietarioService.findAll();
	      modelAndView.addObject("propietarios", propietarios);
	      modelAndView.addObject("accion", "crear");
	      modelAndView.addObject("titulo", "Creación de Barco");
	      return modelAndView;
	  }

	    @PostMapping("/crear")
	    public ModelAndView crearBarco(@ModelAttribute("barco") Barco barco) {
	        try {
	            barcoService.create(barco);
	            return new ModelAndView("redirect:/emarina/barco/consultar");
	        } catch (RuntimeException e) {
	            ModelAndView modelAndView = new ModelAndView("barco/crearBarco");
	            List<Propietario> propietarios = propietarioService.findAll();
	            modelAndView.addObject("propietarios", propietarios);
	            modelAndView.addObject("error", "Ocurrió un error al crear el barco.");
	            modelAndView.addObject("barco", barco);
	            return modelAndView;
	        }
	    }
	  
	    
	    @GetMapping("/inicioEditar")
	    public ModelAndView inicioEditar(@RequestParam("id") String id) {
	        ModelAndView modelAndView = new ModelAndView("barco/editarBarco");
	        Barco barco = barcoService.findByIdBarco(id);
	        List<Propietario> propietarios = propietarioService.findAll(); 
	        modelAndView.addObject("barco", barco);
	        modelAndView.addObject("propietarios", propietarios);
	        return modelAndView;
	    }
	    
	    
	    @PostMapping("/editar")
	    public ModelAndView editarBarco(@ModelAttribute("barco") Barco barco) {
	        try {
	           barcoService.update(barco);
	            return new ModelAndView("redirect:/emarina/barco/consultar");
	        } catch (RuntimeException e) {
	            ModelAndView modelAndView = new ModelAndView("barco/editarBarco");
	            modelAndView.addObject("error", "Ocurrió un error al guardar los cambios.");
	            modelAndView.addObject("barco", barco);
	            return modelAndView;
	        }
	    }
	    
	    
	    
	    
	    
	    
	    @PostMapping("/eliminar")
	    public ModelAndView eliminarBarco(@RequestParam("id") String id) {
	        barcoService.delete(id);
	        return new ModelAndView("redirect:/emarina/barco/consultar");
	    }
	   
}

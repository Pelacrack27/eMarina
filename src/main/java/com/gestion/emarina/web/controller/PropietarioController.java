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

import com.gestion.emarina.domain.Propietario;
import com.gestion.emarina.service.PropietarioServiceInterface;


@Controller
@RequestMapping("/emarina/propietario")
public class PropietarioController {

	
	  @Autowired
	    private PropietarioServiceInterface propietarioService;
	  
	  
	  @GetMapping("/consultar")
	    public ModelAndView obtenerListaPropietarios() {
	        ModelAndView modelAndView = new ModelAndView("propietario/consultarPropietario"); 
	        List<Propietario> propietarios = propietarioService.findAll();
	        modelAndView.addObject("propietarios", propietarios);
	        return modelAndView;
	    }
	  
	
	  
	  @GetMapping("/inicioCrear")
	    public ModelAndView inicioCrear(@ModelAttribute("propietario") Propietario propietario) {
	        ModelAndView modelAndView = new ModelAndView("propietario/crearPropietario");
	        modelAndView.addObject("propietario", new Propietario()); // Inicializa un nuevo propietario
	        modelAndView.addObject("accion", "crear");
	        modelAndView.addObject("titulo", "Creación de Propietario");
	        return modelAndView;
	    }

	    @PostMapping("/crear")
	    public ModelAndView crearPropietario(@ModelAttribute("propietario") Propietario propietario) {
	        try {
	        	
	            propietarioService.create(propietario);
	            return new ModelAndView("redirect:/emarina/propietario/consultar");
	        } catch (RuntimeException e) {
	            ModelAndView modelAndView = new ModelAndView("propietario/crearPropietario");
	            modelAndView.addObject("error", "Ocurrió un error al crear el propietario.");
	            modelAndView.addObject("propietario", propietario);
	            return modelAndView;
	        }
	    }
	 
	    @GetMapping("/inicioEditar")
	    public ModelAndView inicioEditar(@RequestParam("id") String id) {
	        ModelAndView modelAndView = new ModelAndView("propietario/editarPropietario");
	        Propietario propietario = propietarioService.findByIdPropietario(id);
	        modelAndView.addObject("propietario", propietario);
	        return modelAndView;
	    }
	    
	    
	    @PostMapping("/editar")
	    public ModelAndView editarPropietario(@ModelAttribute("propietario") Propietario propietario) {
	        try {
	            propietarioService.update(propietario);
	            return new ModelAndView("redirect:/emarina/propietario/consultar");
	        } catch (RuntimeException e) {
	            ModelAndView modelAndView = new ModelAndView("propietario/editarPropietario");
	            modelAndView.addObject("error", "Ocurrió un error al guardar los cambios.");
	            modelAndView.addObject("propietario", propietario);
	            return modelAndView;
	        }
	    }
	    
	    
	    
	    @PostMapping("/eliminar")
	    public ModelAndView eliminarPropietario(@RequestParam("id") String id) {
	        try {
	            propietarioService.delete(id);
	            return new ModelAndView("redirect:/emarina/propietario/consultar");
	        } catch (RuntimeException e) {
	            ModelAndView modelAndView = new ModelAndView("propietario/consultarPropietario");
	            modelAndView.addObject("error", "Ocurrió un error al eliminar el propietario.");
	            List<Propietario> propietarios = propietarioService.findAll();
	            modelAndView.addObject("propietarios", propietarios);
	            return modelAndView;
	        }
	    }
	  
	    
}

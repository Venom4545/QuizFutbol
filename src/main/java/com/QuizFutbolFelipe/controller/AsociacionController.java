package com.QuizFutbolFelipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.QuizFutbolFelipe.entity.Asociacion;
import com.QuizFutbolFelipe.repository.AsociacionRepository;



@Controller
public class AsociacionController {


    @Autowired
	private AsociacionRepository asociacionRepositorio;


    @GetMapping({"/verAsociacion","/mostrarAsociacion","/listarAsociacion"})  
	public String listarAsociacion(Model model) {
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		return "verAsociacion";
	}

    @GetMapping("/verAsociacion/formAsociacion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("asociacion", new Asociacion()); // Asegurando que hay un objeto entrenador para el formulario
        return "formAsociacion"; // Asegúrate de tener formEntrenador.html en templates
    }

    @PostMapping("/guardarAsociacion")
    public String guardarAsociacion(Asociacion asociacion, Model model) {     
        asociacionRepositorio.save(asociacion);
        return "redirect:/verAsociacion";
    }

    @GetMapping("/asociacion/editar/{id}")
	public String modificarClub (@PathVariable("id") Integer id, Model model) {
		Asociacion asociacion = asociacionRepositorio.findById(id).get();
		model.addAttribute("asociacion", asociacion);	
		
		return "formAsociacion";
	}

    @GetMapping("/asociacion/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Integer id, Model model) {
		asociacionRepositorio.deleteById(id);
		return "redirect:/verAsociacion";
	}
}

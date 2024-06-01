package com.QuizFutbolFelipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.QuizFutbolFelipe.entity.Entrenadores;
import com.QuizFutbolFelipe.repository.EntrenadoresRepository;



@Controller
public class EntrenadorController {

    @Autowired
	private EntrenadoresRepository entrenadorRepositorio;


    @GetMapping({"/verEntrenador","/mostrarEntrenador","/listarEntrenador"})  
	public String listarEntrenador(Model model) {
		List<Entrenadores> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "verEntrenador";
	}

	@GetMapping("/verEntrenador/formEntrenador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("entrenadores", new Entrenadores()); // Asegurando que hay un objeto entrenador para el formulario
        return "formEntrenador"; // Asegúrate de tener formEntrenador.html en templates
    }

	@PostMapping("/guardarEntrenador")
    public String guardarClub(Entrenadores entrenadores, Model model) {     
        entrenadorRepositorio.save(entrenadores);
        return "redirect:/verEntrenador";
    }

    @GetMapping("/entrenadores/editar/{id}")
	public String modificarClub (@PathVariable("id") Integer id, Model model) {
		Entrenadores entrenadores = entrenadorRepositorio.findById(id).get();
		model.addAttribute("entrenadores", entrenadores);	
		
		return "formEntrenador";
	}
    
    @GetMapping("/entrenadores/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Integer id, Model model) {
		entrenadorRepositorio.deleteById(id);
		return "redirect:/verEntrenador";
	}
}

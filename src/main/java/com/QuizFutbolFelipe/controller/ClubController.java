package com.QuizFutbolFelipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.QuizFutbolFelipe.entity.*;
import com.QuizFutbolFelipe.repository.*;



@Controller
public class ClubController {


    @Autowired
	private ClubRepository clubRepositorio;
	
	@Autowired
	private EntrenadoresRepository entrenadorRepositorio;
	
	@Autowired
	private AsociacionRepository asociacionRepositorio;
	
	@GetMapping("/index")
    public String index() {
        return "index";  
    }
	
	@GetMapping({"/verClub","/mostrarclub","/listarclub"})  
	public String listarClub(Model model) {
		List<Club> listaClub = clubRepositorio.findAll();
		model.addAttribute("listaClub", listaClub);
		
		return "verClub";
	}
	
	@GetMapping("/verClub/formClub")
	public String mostrarFormulario (Model model) {
		model.addAttribute("club", new Club());
		
		List<Entrenadores> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		
		
		return "formClub";
	}
	
	// @PostMapping("/guardarClub")
	// public String guardarClub (Club club) {
	// 	clubRepositorio.save(club);
	// 	return "redirect:/verClub";
	// }

	@PostMapping("/guardarClub")
    public String guardarClub(Club club, Model model) {
        // Verifica si ya existe un club con el mismo entrenador
        if (clubRepositorio.existsByEntrenadoresId(club.getEntrenadores().getId())) {
            model.addAttribute("error", "El entrenador ya está asignado a otro club.");
            return "formClub"; // Regresa al formulario con un mensaje de error
        }
        
        // Verifica si ya existe un club con la misma asociación
        if (clubRepositorio.existsByAsociacionId(club.getAsociacion().getId())) {
            model.addAttribute("error", "La asociación ya está asignada a otro club.");
            return "formClub"; // Regresa al formulario con un mensaje de error
        }
        
        clubRepositorio.save(club);
        return "redirect:/verClub";
    }
	
	@GetMapping("/club/editar/{id}")
	public String modificarClub (@PathVariable("id") Integer id, Model model) {
		Club club = clubRepositorio.findById(id).get();
		model.addAttribute("club", club);
		
		List<Entrenadores> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		
		
		return "formClub";
	}
	
	@GetMapping("/club/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Integer id, Model model) {
		clubRepositorio.deleteById(id);
		return "redirect:/verClub";
	}

}

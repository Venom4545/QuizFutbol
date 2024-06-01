package com.QuizFutbolFelipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.QuizFutbolFelipe.entity.Club;
import com.QuizFutbolFelipe.entity.Jugador;
import com.QuizFutbolFelipe.repository.ClubRepository;
import com.QuizFutbolFelipe.repository.JugadorRepository;

@Controller
public class JugadorController {

    @Autowired
    private JugadorRepository jugadorRepositorio;
    
    @Autowired
	private ClubRepository clubRepositorio;

    @GetMapping({"/verJugador","/mostrarJugador","/listarJugador"})  
	public String listarJugador(Model model) {
		List<Jugador> listaJugador = jugadorRepositorio.findAll();
		model.addAttribute("listaJugador", listaJugador);
		
		return "verJugador";
	}
    
    @GetMapping("/verJugador/formJugador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("jugador", new Jugador()); // Agregar un nuevo objeto Jugador al modelo
        
        List<Club> listaClub = clubRepositorio.findAll();
		model.addAttribute("listaClub", listaClub);
		
        return "formJugador"; // Devolver la vista formJugador
    }


    @PostMapping("/guardarJugador")
    public String guardarJugador(Jugador jugador, Model model) {     
        jugadorRepositorio.save(jugador);
        return "redirect:/verJugador";
    }

    @GetMapping("/jugador/editar/{id}")
    public String modificarJugador(@PathVariable("id") Integer id, Model model) {
        Jugador jugador = jugadorRepositorio.findById(id).orElse(null);
        model.addAttribute("jugador", jugador);	
        
        List<Club> listaClub = clubRepositorio.findAll();
		model.addAttribute("listaClub", listaClub);
		
        return "formJugador";
    }

    @GetMapping("/jugador/eliminar/{id}")
    public String eliminarJugador(@PathVariable("id") Integer id, Model model) {
        jugadorRepositorio.deleteById(id);
        
        List<Club> listaClub = clubRepositorio.findAll();
		model.addAttribute("listaClub", listaClub);
		
        return "redirect:/verJugador";
    }

    
	
}

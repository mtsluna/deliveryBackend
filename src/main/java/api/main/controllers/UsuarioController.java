package api.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.main.services.UsuarioService;

@Controller
@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService){
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/existemail/{email}")
	@CrossOrigin(origins = "*")
	public String existEmail(@PathVariable String email) {
		return usuarioService.existEmail(email);
	}
	
}

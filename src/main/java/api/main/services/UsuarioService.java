package api.main.services;

import org.springframework.stereotype.Service;

import api.main.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public String existEmail(String email) {

		String resultado = usuarioRepository.existEmail(email);

		if (resultado != "0") {
			return "{\"emailExist\": \"true\"}";
		}

		return "{\"emailExist\": \"false\"}";

	}

}

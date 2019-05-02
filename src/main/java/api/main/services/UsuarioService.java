package api.main.services;

import org.springframework.stereotype.Service;

import api.main.model.Rol;
import api.main.repositories.RolRepository;
import api.main.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	private RolRepository rolRepository;

	public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
		this.usuarioRepository = usuarioRepository;
		this.rolRepository = rolRepository;
	}

	public String existEmail(String email) {

		String resultado = usuarioRepository.existEmail(email);

		if (resultado != "0") {
			return "{\"emailExist\": \"true\"}";
		}

		return "{\"emailExist\": \"false\"}";

	}
	
	public String rolByEmail(String email) {
		String resultado = usuarioRepository.rolByEmail(email);
		
		if(resultado != null) {
			Rol rol = rolRepository.findById(Integer.parseInt(resultado)).get();
			return "{ \"rol\": \""+rol.getNombre()+"\" }";
		}
		else {
			return "{ \"rol\": \"null\" }";
		}	
	}

}

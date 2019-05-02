package api.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.main.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "SELECT COUNT(usuario_email) FROM api_usuario WHERE usuario_email = ?1", nativeQuery = true)
	public String existEmail(String email);
	
	@Query(value = "SELECT fk_posee_rol FROM api_usuario WHERE usuario_email = ?1", nativeQuery = true)
	public String rolByEmail(String email);
	
}

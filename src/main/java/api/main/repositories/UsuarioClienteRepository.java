package api.main.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import api.main.model.UsuarioCliente;

@Repository
public interface UsuarioClienteRepository extends JpaRepository <UsuarioCliente, Integer>{
	
	@Query(value = "SELECT * FROM api_usuario WHERE usuario_email = ?1", nativeQuery  =true)
	public Optional<UsuarioCliente> searchByEmail(String email);
	
}


package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import api.main.model.UsuarioCliente;

@Repository
public interface UsuarioClienteRepository extends JpaRepository <UsuarioCliente, Integer>{}


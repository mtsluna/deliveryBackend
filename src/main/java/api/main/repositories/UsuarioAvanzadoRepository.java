package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import api.main.model.UsuarioAvanzado;

@Repository
public interface UsuarioAvanzadoRepository extends JpaRepository <UsuarioAvanzado, Integer>{}


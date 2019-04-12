package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.UnidadMedida;

@Repository
public interface UnidadMedidaRepository extends JpaRepository <UnidadMedida, Integer>{}


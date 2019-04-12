package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.PlatoDetalle;

@Repository
public interface PlatoDetalleRepository extends JpaRepository <PlatoDetalle, Integer>{}


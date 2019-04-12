package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository <Detalle, Integer>{}


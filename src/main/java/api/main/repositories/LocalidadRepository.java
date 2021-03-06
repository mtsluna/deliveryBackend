package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Localidad;

@Repository
public interface LocalidadRepository extends JpaRepository <Localidad, Integer>{}


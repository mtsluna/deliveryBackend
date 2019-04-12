package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.PlatoCategoria;

@Repository
public interface PlatoCategoriaRepository extends JpaRepository <PlatoCategoria, Integer>{}


package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Plato;

@Repository
public interface PlatoRepository extends JpaRepository <Plato, Integer>{}


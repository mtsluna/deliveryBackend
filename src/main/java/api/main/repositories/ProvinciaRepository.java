package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository <Provincia, Integer>{}


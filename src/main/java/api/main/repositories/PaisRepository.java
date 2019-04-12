package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository <Pais, Integer>{}


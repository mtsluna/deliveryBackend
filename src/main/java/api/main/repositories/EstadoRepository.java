package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository <Estado, Integer>{}


package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Domicilio;

@Repository
public interface DomicilioRepository extends JpaRepository <Domicilio, Integer>{}


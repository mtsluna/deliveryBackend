package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository <Factura, Integer>{}


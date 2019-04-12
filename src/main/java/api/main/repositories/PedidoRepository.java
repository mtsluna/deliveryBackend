package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer>{}


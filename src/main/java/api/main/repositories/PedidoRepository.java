package api.main.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import api.main.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer>{
	
	@Query(value = "SELECT * FROM api_comprobante WHERE fk_posee_usuario = ?1", nativeQuery = true)
	public List<Pedido> getAllByUser(int id);
	
}


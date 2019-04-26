package api.main.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import api.main.model.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository <Articulo, Integer>{
	
	@Query(value = "SELECT * FROM api_articulo WHERE articulo_esinsumo=?1", nativeQuery = true)
	public List<Articulo> getAllNoInsumos(boolean esInsumo);
	
}


package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.ArticuloCategoria;

@Repository
public interface ArticuloCategoriaRepository extends JpaRepository <ArticuloCategoria, Integer>{}


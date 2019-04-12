package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository <Imagen, Integer>{}


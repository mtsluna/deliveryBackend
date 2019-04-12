package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Rol;

@Repository
public interface RolRepository extends JpaRepository <Rol, Integer>{}


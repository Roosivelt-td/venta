package automoviles.repository;

import automoviles.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
    // Métodos personalizados:
    List<Auto> findByMarca(String marca);
}
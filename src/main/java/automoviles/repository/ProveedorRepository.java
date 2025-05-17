package automoviles.repository;

import automoviles.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    // Método para buscar proveedor por RUC (generado automáticamente por Spring Data JPA).
    Proveedor findByRuc(String ruc);
}
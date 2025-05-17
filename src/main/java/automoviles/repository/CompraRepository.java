package automoviles.repository;

import automoviles.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    // Buscar compras por proveedor
    List<Compra> findByProveedorId(Long proveedorId);

    // Buscar compras por auto
    List<Compra> findByAutoId(Long autoId);
}
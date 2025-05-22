package automoviles.repository;

import automoviles.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByClienteId(Long clienteId);
    List<Venta> findByAutoId(Long autoId);
    List<Venta> findByUsuarioId(Long usuarioId);
}
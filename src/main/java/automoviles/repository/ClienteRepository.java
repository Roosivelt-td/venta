package automoviles.repository;

import automoviles.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Metodo para buscar cliente por DNI (generado automáticamente por Spring Data JPA).
    Cliente findByDni(String dni);
}
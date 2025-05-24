package automoviles.repository;

import automoviles.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    Viaje findByCorreo(String correo); // Método personalizado
}
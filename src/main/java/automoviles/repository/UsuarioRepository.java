package automoviles.repository;

import automoviles.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta interfaz es un componente de repositorio de Spring.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método para buscar un usuario por su correo (generado automáticamente por Spring Data JPA).
    Usuario findByCorreo(String correo);
}
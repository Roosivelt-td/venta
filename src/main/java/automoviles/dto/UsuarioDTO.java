
package automoviles.dto;

import automoviles.model.Usuario;
import lombok.Data;
/**
 * DTO (Data Transfer Object) para la entidad Usuario.
 * Se utiliza para transferir datos entre el cliente y el servidor
 * sin exponer directamente la entidad de base de datos.
 *
 * Ventajas:
 * - Controlar qué datos se exponen
 * - Evitar exposición de información sensible
 * - Personalizar datos para diferentes vistas
 */


@Data // Lombok para generar getters y setters.
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String rol;
    private Boolean estado;
}
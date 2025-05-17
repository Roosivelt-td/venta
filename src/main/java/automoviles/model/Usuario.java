package automoviles.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla en la base de datos.
@Table(name = "usuarios") // Especifica el nombre de la tabla en la base de datos.
@Data // Anotación de Lombok para generar automáticamente getters, setters, toString, etc.
public class Usuario {

    @Id // Indica que este campo es la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el valor del ID (autoincremental).
    private Long id;

    @Column(name = "nombre", length = 100) // Mapea el campo "nombre" de la tabla.
    private String nombre;

    @Column(name = "apellido", length = 100)
    private String apellido;

    @Column(name = "correo", length = 100, unique = true) // "unique = true" asegura que el correo sea único.
    private String correo;

    @Column(name = "contrasena", length = 255)
    private String contrasena;

    @Column(name = "rol", nullable = false, length = 20) // Longitud ajustable
    private String rol;

    @Column(name = "estado", columnDefinition = "BOOLEAN DEFAULT TRUE") // Define un valor por defecto.
    private Boolean estado;
}
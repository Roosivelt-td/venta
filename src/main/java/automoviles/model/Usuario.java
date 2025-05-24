package automoviles.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios") // Mapea a la tabla "usuarios" en la DB
@Data // Lombok: genera getters, setters, toString, etc.
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincremental
    @Column(name = "id") // Columna "id" en la tabla
    private Long id;

    @Column(name = "nombre", nullable = false) // Columna "nombre", no nula
    private String nombre;

    @Column(name = "apellido", nullable = false) // Columna "apellido", no nula
    private String apellido;

    @Column(name = "correo", unique = true, nullable = false) // Columna "correo", única y no nula
    private String correo;

    @Column(name = "contrasena", nullable = false) // Columna "contrasena", no nula
    private String contrasena;

    @Column(name = "rol", nullable = false) // Columna "rol", no nula
    private String rol;

    @Column(name = "estado", columnDefinition = "BOOLEAN DEFAULT TRUE") // Columna "estado", valor por defecto TRUE
    private Boolean estado;
}
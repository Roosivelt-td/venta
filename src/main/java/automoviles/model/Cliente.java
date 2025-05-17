package automoviles.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clientes") // Nombre de la tabla en la base de datos.
@Data // Lombok: getters, setters, toString, etc.
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "dni", length = 15, unique = true) // DNI único.
    private String dni;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "direccion", columnDefinition = "TEXT") // Usa tipo TEXT en la base de datos.
    private String direccion;

    @Column(name = "correo", length = 100)
    private String correo;
}
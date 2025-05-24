package automoviles.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "viajes") // Mapea a la tabla "usuarios" en la DB
@Data // Lombok: genera getters, setters, toString, etc.
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincremental
    @Column(name = "id") // Columna "id" en la tabla
    private Long id;

    @Column(name = "origen", nullable = false)
    private String origen;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "conductor", unique = true, nullable = false)
    private String conductor;

    @Column(name = "fechaSalida", nullable = false)
    private String fechaSalida;

    @Column(name = "fechaLlegada", nullable = false)
    private String fechaLlegada;

    @Column(name = "fechaCreacion", nullable = false)
    private Integer fechaCreacion;
}
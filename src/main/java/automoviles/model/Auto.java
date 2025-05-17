package automoviles.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "autos")
@Data
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca", length = 50)
    private String marca;

    @Column(name = "modelo", length = 50)
    private String modelo;

    @Column(name = "anio")
    private Integer anio;  // Usamos Integer en lugar de Year para mayor compatibilidad.

    @Column(name = "color", length = 30)
    private String color;

    @Column(name = "kilometraje")
    private Integer kilometraje;

    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "precio", precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "imagen_url", columnDefinition = "TEXT")
    private String imagenUrl;

    @Column(name = "estado", length = 15)
    private String estado;

}
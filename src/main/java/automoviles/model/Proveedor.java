package automoviles.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "proveedores")
@Data
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_empresa", length = 100)
    private String nombreEmpresa;

    @Column(name = "ruc", length = 15, unique = true)
    private String ruc;

    @Column(name = "contacto", length = 100)
    private String contacto;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "direccion", columnDefinition = "TEXT")
    private String direccion;
}
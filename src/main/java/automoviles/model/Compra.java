package automoviles.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "compras")
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // Relación muchos-a-uno con Proveedor
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)  // Relación muchos-a-uno con Auto
    @JoinColumn(name = "id_auto", nullable = false)
    private Auto auto;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)  // Solo almacena la fecha (sin hora)
    private Date fecha;

    @Column(name = "precio_compra", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioCompra;  // Usamos BigDecimal para precisión en montos
}
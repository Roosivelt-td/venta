package automoviles.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ReembolsoDTO {
    private Long id;
    private Long idVenta;  // Solo guarda el ID de la venta
    private String motivo;
    private BigDecimal monto;
    private Date fecha;
}
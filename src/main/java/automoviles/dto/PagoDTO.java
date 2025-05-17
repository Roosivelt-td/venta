package automoviles.dto;

import automoviles.model.Pago;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PagoDTO {
    private Long id;
    private Long idVenta;
    private String MetodoPago;
    private BigDecimal monto;
    private Date fecha;
}
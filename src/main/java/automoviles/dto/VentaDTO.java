package automoviles.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class VentaDTO {
    private Long id;
    private Long idCliente;
    private Long idAuto;
    private Long idUsuario;
    private Date fecha;
    private BigDecimal precioVenta;
}
package automoviles.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CompraDTO {
    private Long id;
    private Long idProveedor;  // Solo necesitamos el ID del proveedor
    private Long idAuto;       // Solo necesitamos el ID del auto
    private Date fecha;
    private BigDecimal precioCompra;
}
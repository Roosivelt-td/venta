package automoviles.service.mapper;

import automoviles.dto.PagoDTO;
import automoviles.model.Pago;
import automoviles.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class PagoMapper {

    public PagoDTO toDto(Pago pago) {
        PagoDTO dto = new PagoDTO();
        dto.setId(pago.getId());
        dto.setIdVenta(pago.getVenta().getId());
        dto.setMetodoPago(pago.getMetodoPago());
        dto.setMonto(pago.getMonto());
        dto.setFecha(pago.getFecha());
        return dto;
    }

    public Pago toEntity(PagoDTO dto, Venta venta) {
        Pago pago = new Pago();
        pago.setId(dto.getId());
        pago.setVenta(venta);
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setMonto(dto.getMonto());
        pago.setFecha(dto.getFecha());
        return pago;
    }
}
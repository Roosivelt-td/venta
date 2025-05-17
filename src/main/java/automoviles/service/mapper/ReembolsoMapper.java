package automoviles.service.mapper;

import automoviles.dto.ReembolsoDTO;
import automoviles.model.Reembolso;
import automoviles.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class ReembolsoMapper {

    public ReembolsoDTO toDto(Reembolso reembolso) {
        ReembolsoDTO dto = new ReembolsoDTO();
        dto.setId(reembolso.getId());
        dto.setIdVenta(reembolso.getVenta().getId());
        dto.setMotivo(reembolso.getMotivo());
        dto.setMonto(reembolso.getMonto());
        dto.setFecha(reembolso.getFecha());
        return dto;
    }

    public Reembolso toEntity(ReembolsoDTO dto, Venta venta) {
        Reembolso reembolso = new Reembolso();
        reembolso.setId(dto.getId());
        reembolso.setVenta(venta);
        reembolso.setMotivo(dto.getMotivo());
        reembolso.setMonto(dto.getMonto());
        reembolso.setFecha(dto.getFecha());
        return reembolso;
    }
}
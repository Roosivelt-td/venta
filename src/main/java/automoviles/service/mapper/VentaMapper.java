package automoviles.service.mapper;

import automoviles.dto.VentaDTO;
import automoviles.model.*;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {

    public VentaDTO toDto(Venta venta) {
        VentaDTO dto = new VentaDTO();
        dto.setId(venta.getId());
        dto.setIdCliente(venta.getCliente().getId());
        dto.setIdAuto(venta.getAuto().getId());
        dto.setIdUsuario(venta.getUsuario().getId());
        dto.setFecha(venta.getFecha());
        dto.setPrecioVenta(venta.getPrecioVenta());
        return dto;
    }

    public Venta toEntity(VentaDTO dto, Cliente cliente, Auto auto, Usuario usuario) {
        Venta venta = new Venta();
        venta.setId(dto.getId());
        venta.setCliente(cliente);
        venta.setAuto(auto);
        venta.setUsuario(usuario);
        venta.setFecha(dto.getFecha());
        venta.setPrecioVenta(dto.getPrecioVenta());
        return venta;
    }
}
package automoviles.service.mapper;

import automoviles.dto.CompraDTO;
import automoviles.model.Compra;
import automoviles.model.Proveedor;
import automoviles.model.Auto;
import org.springframework.stereotype.Component;

@Component
public class CompraMapper {

    public CompraDTO toDto(Compra compra) {
        CompraDTO dto = new CompraDTO();
        dto.setId(compra.getId());
        dto.setIdProveedor(compra.getProveedor().getId());
        dto.setIdAuto(compra.getAuto().getId());
        dto.setFecha(compra.getFecha());
        dto.setPrecioCompra(compra.getPrecioCompra());
        return dto;
    }

    public Compra toEntity(CompraDTO dto, Proveedor proveedor, Auto auto) {
        Compra compra = new Compra();
        compra.setId(dto.getId());
        compra.setProveedor(proveedor);
        compra.setAuto(auto);
        compra.setFecha(dto.getFecha());
        compra.setPrecioCompra(dto.getPrecioCompra());
        return compra;
    }
}
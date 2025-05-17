package automoviles.service.mapper;

import automoviles.dto.ProveedorDTO;
import automoviles.model.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {

    public ProveedorDTO toDto(Proveedor proveedor) {
        ProveedorDTO dto = new ProveedorDTO();
        dto.setId(proveedor.getId());
        dto.setNombreEmpresa(proveedor.getNombreEmpresa());
        dto.setRuc(proveedor.getRuc());
        dto.setContacto(proveedor.getContacto());
        dto.setTelefono(proveedor.getTelefono());
        dto.setDireccion(proveedor.getDireccion());
        return dto;
    }

    public Proveedor toEntity(ProveedorDTO dto) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(dto.getId());
        proveedor.setNombreEmpresa(dto.getNombreEmpresa());
        proveedor.setRuc(dto.getRuc());
        proveedor.setContacto(dto.getContacto());
        proveedor.setTelefono(dto.getTelefono());
        proveedor.setDireccion(dto.getDireccion());
        return proveedor;
    }
}
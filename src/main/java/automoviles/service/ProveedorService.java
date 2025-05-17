package automoviles.service;

import automoviles.dto.ProveedorDTO;
import java.util.List;

public interface ProveedorService {
    ProveedorDTO crearProveedor(ProveedorDTO proveedorDTO);
    ProveedorDTO obtenerProveedorPorId(Long id);
    List<ProveedorDTO> obtenerTodosLosProveedores();
    ProveedorDTO actualizarProveedor(Long id, ProveedorDTO proveedorDTO);
    void eliminarProveedor(Long id);
}
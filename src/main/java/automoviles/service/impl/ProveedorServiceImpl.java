package automoviles.service.impl;

import automoviles.dto.ProveedorDTO;
import automoviles.model.Proveedor;
import automoviles.repository.ProveedorRepository;
import automoviles.service.ProveedorService;
import automoviles.service.mapper.ProveedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorMapper proveedorMapper;

    @Override
    public ProveedorDTO crearProveedor(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = proveedorMapper.toEntity(proveedorDTO);
        proveedor = proveedorRepository.save(proveedor);
        return proveedorMapper.toDto(proveedor);
    }

    @Override
    public ProveedorDTO obtenerProveedorPorId(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        return proveedorMapper.toDto(proveedor);
    }

    @Override
    public List<ProveedorDTO> obtenerTodosLosProveedores() {
        return proveedorRepository.findAll().stream()
                .map(proveedorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProveedorDTO actualizarProveedor(Long id, ProveedorDTO proveedorDTO) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        proveedor.setNombreEmpresa(proveedorDTO.getNombreEmpresa());
        proveedor.setRuc(proveedorDTO.getRuc());
        proveedor.setContacto(proveedorDTO.getContacto());
        proveedor.setTelefono(proveedorDTO.getTelefono());
        proveedor.setDireccion(proveedorDTO.getDireccion());
        proveedor = proveedorRepository.save(proveedor);
        return proveedorMapper.toDto(proveedor);
    }

    @Override
    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
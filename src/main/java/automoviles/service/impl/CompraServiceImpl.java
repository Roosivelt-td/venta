package automoviles.service.impl;

import automoviles.dto.CompraDTO;
import automoviles.model.*;
import automoviles.repository.*;
import automoviles.service.CompraService;
import automoviles.service.mapper.CompraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private CompraMapper compraMapper;

    @Override
    public CompraDTO crearCompra(CompraDTO compraDTO) {
        Proveedor proveedor = proveedorRepository.findById(compraDTO.getIdProveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        Auto auto = autoRepository.findById(compraDTO.getIdAuto())
                .orElseThrow(() -> new RuntimeException("Auto no encontrado"));

        Compra compra = compraMapper.toEntity(compraDTO, proveedor, auto);
        compra = compraRepository.save(compra);
        return compraMapper.toDto(compra);
    }

    @Override
    public CompraDTO obtenerCompraPorId(Long id) {
        Compra compra = compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
        return compraMapper.toDto(compra);
    }

    @Override
    public List<CompraDTO> obtenerTodasLasCompras() {
        return compraRepository.findAll().stream()
                .map(compraMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CompraDTO> obtenerComprasPorProveedor(Long proveedorId) {
        return compraRepository.findByProveedorId(proveedorId).stream()
                .map(compraMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CompraDTO> obtenerComprasPorAuto(Long autoId) {
        return compraRepository.findByAutoId(autoId).stream()
                .map(compraMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarCompra(Long id) {
        compraRepository.deleteById(id);
    }
}
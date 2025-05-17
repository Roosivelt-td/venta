package automoviles.service;

import automoviles.dto.CompraDTO;
import java.util.List;

public interface CompraService {
    CompraDTO crearCompra(CompraDTO compraDTO);
    CompraDTO obtenerCompraPorId(Long id);
    List<CompraDTO> obtenerTodasLasCompras();
    List<CompraDTO> obtenerComprasPorProveedor(Long proveedorId);
    List<CompraDTO> obtenerComprasPorAuto(Long autoId);
    void eliminarCompra(Long id);
}
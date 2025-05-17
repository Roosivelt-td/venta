package automoviles.service;

import automoviles.dto.VentaDTO;
import java.util.List;

public interface VentaService {
    VentaDTO crearVenta(VentaDTO ventaDTO);
    VentaDTO obtenerVentaPorId(Long id);
    List<VentaDTO> obtenerTodasLasVentas();
    List<VentaDTO> obtenerVentasPorCliente(Long clienteId);
    List<VentaDTO> obtenerVentasPorAuto(Long autoId);
    List<VentaDTO> obtenerVentasPorUsuario(Long usuarioId);
    void eliminarVenta(Long id);
}
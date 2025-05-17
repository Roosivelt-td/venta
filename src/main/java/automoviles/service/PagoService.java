package automoviles.service;

import automoviles.dto.PagoDTO;
import java.util.List;

public interface PagoService {
    PagoDTO crearPago(PagoDTO pagoDTO);
    List<PagoDTO> obtenerPagosPorVenta(Long ventaId);
    void eliminarPago(Long id);
}
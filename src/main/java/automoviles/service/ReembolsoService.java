package automoviles.service;

import automoviles.dto.ReembolsoDTO;
import java.util.List;

public interface ReembolsoService {
    ReembolsoDTO crearReembolso(ReembolsoDTO reembolsoDTO);
    List<ReembolsoDTO> obtenerReembolsosPorVenta(Long ventaId);
    void eliminarReembolso(Long id);
}
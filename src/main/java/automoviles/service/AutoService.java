package automoviles.service;

import automoviles.dto.AutoDTO;
import java.util.List;

public interface AutoService {
    AutoDTO crearAuto(AutoDTO autoDTO);
    AutoDTO obtenerAutoPorId(Long id);
    List<AutoDTO> obtenerTodosLosAutos();
    AutoDTO actualizarAuto(Long id, AutoDTO autoDTO);
    void eliminarAuto(Long id);
    List<AutoDTO> buscarPorMarca(String marca);
    List<AutoDTO> buscarPorEstado(String estado);
}
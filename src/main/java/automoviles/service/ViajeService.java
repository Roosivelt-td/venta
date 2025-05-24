package automoviles.service;

import automoviles.dto.ViajeDto;
import java.util.List;

public interface ViajeService {
    ViajeDto crearviaje(ViajeDto viajeDto);
    ViajeDto obtenerViajePorId(Long id);
    List<ViajeDto> obtenerTodosLosViajes();
    ViajeDto actualizarViaje(Long id, ViajeDto viajeDto);
    void eliminarViaje(Long id);
}
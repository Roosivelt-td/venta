package automoviles.service.impl;

import automoviles.dto.ViajeDto;
import automoviles.model.Viaje;
import automoviles.repository.ViajeRepository;
import automoviles.service.ViajeService;
import automoviles.service.mapper.ViajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViajeServiceImpl implements ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private ViajeMapper viajeMapper;

    @Override
    public ViajeDto crearViaje(ViajeDto viajeDto) {
        Viaje viaje = viajeMapper.toEntity(viajeDto);
        viaje = viajeRepository.save(viaje);
        return viajeMapper.toDto(viaje);
    }

    @Override
    public ViajeDto obtenerViajePorId(Long id) {
        Viaje viaje = viajeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
        return viajeMapper.toDto(viaje);
    }

    @Override
    public List<ViajeDto> obtenerTodosLosViajes() {
        return viajeRepository.findAll().stream()
                .map(viajeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ViajeDto actualizarViaje(Long id, ViajeDto viajeDto) {
        Viaje viaje = viajeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
        viaje.setOrigen(viajeDto.getOrigen());
        viaje.setDestino(viajeDto.getDestino());
        viaje.setConductor(viajeDto.getConductor());
        viaje.setFechaSalida(viajeDto.getFechaSalida());
        viaje.setFechaLlegada(viajeDto.getFechaSalida());
        viaje.setFechaCreacion(viajeDto.getFechaCreacion());
        viaje = viajeRepository.save(viaje);
        return viajeMapper.toDto(viaje);
    }

    @Override
    public void eliminarViaje(Long id) {
        viajeRepository.deleteById(id);
    }
}
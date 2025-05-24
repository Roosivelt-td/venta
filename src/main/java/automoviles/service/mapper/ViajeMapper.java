package automoviles.service.mapper;

import automoviles.dto.ViajeDto;
import automoviles.model.Viaje;
import org.springframework.stereotype.Component;

@Component
public class ViajeMapper {

    public ViajeDto toDto(Viaje viaje) {
        ViajeDto dto = new ViajeDto();
        dto.setId(viaje.getId());
        dto.setOrigen(viaje.getOrigen());
        dto.setDestino(viaje.getDestino());
        dto.setConductor(viaje.getConductor());
        dto.setFechaSalida(viaje.getFechaSalida());
        dto.setFechaLlegada(viaje.getFechaLlegada());
        dto.setFechaCreacion(viaje.getFechaCreacion());
        return dto;
    }

    public Viaje toEntity(ViajeDto dto) {
        Viaje viaje = new Viaje();
        viaje.setOrigen(dto.getOrigen());
        viaje.setDestino(dto.getDestino());
        viaje.setConductor(dto.getConductor());
        viaje.setFechaSalida(dto.getFechaSalida());
        viaje.setFechaLlegada(dto.getFechaLlegada());
        viaje.setFechaCreacion(dto.getFechaCreacion());
        return viaje;
    }
}
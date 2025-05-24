package automoviles.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ViajeDto {
    private Long id;
    private String origen;
    private String destino;
    private String conductor;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLlegada;
    private LocalDateTime fechaCreacion;

}
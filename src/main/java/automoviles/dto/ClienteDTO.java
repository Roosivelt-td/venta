package automoviles.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private String direccion;
    private String correo;
}
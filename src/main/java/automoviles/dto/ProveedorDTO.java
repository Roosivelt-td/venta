package automoviles.dto;

import lombok.Data;

@Data
public class ProveedorDTO {
    private Long id;
    private String nombreEmpresa;
    private String ruc;
    private String contacto;
    private String telefono;
    private String direccion;
}
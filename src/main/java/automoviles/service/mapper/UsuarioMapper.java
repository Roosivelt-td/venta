package automoviles.service.mapper;

import automoviles.dto.UsuarioDTO;
import org.springframework.stereotype.Component;
import automoviles.model.Usuario;

/**
 * Mapper para convertir entre la entidad Usuario y UsuarioDTO.
 * Responsabilidades:
 * - Convertir entidad a DTO (para enviar datos al cliente)
 * - Convertir DTO a entidad (para recibir datos del cliente)
 */

@Component // Indica que esta clase es un componente de Spring (para inyección de dependencias).
public class UsuarioMapper {

    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setCorreo(usuario.getCorreo());
        dto.setContrasena(usuario.getContrasena());
        dto.setRol(usuario.getRol());
        dto.setEstado(usuario.getEstado());
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContrasena(dto.getContrasena());
        usuario.setRol(dto.getRol());
        usuario.setEstado(dto.getEstado());
        return usuario;
    }
}
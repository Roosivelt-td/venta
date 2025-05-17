package automoviles.service;

import automoviles.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO obtenerUsuarioPorId(Long id);
    List<UsuarioDTO> obtenerTodosLosUsuarios();
    UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO);
    void eliminarUsuario(Long id);
}
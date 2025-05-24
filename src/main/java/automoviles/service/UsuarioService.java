package automoviles.service;

import automoviles.dto.UsuarioDto;
import java.util.List;

public interface UsuarioService {
    UsuarioDto crearUsuario(UsuarioDto usuarioDto);
    UsuarioDto obtenerUsuarioPorId(Long id);
    List<UsuarioDto> obtenerTodosLosUsuarios();
    UsuarioDto actualizarUsuario(Long id, UsuarioDto usuarioDto);
    void eliminarUsuario(Long id);
}
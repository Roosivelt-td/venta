package automoviles.controller;

import automoviles.dto.UsuarioDTO;
import automoviles.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/api/usuarios") // Define la ruta base para todas las solicitudes en este controlador.
public class UsuarioController {

    @Autowired // Inyecta el servicio automáticamente.
    private UsuarioService usuarioService;

    @PostMapping // Mapea las solicitudes POST a /api/usuarios.
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO nuevoUsuario = usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping("/{id}") // Mapea las solicitudes GET a /api/usuarios/{id}.
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping // Mapea las solicitudes GET a /api/usuarios.
    public ResponseEntity<List<UsuarioDTO>> obtenerTodosLosUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}") // Mapea las solicitudes PUT a /api/usuarios/{id}.
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}") // Mapea las solicitudes DELETE a /api/usuarios/{id}.
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
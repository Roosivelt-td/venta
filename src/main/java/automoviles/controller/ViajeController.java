package automoviles.controller;

import automoviles.dto.ViajeDto;
import automoviles.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @PostMapping("/create")
    public ResponseEntity<ViajeDto> crearViaje(@RequestBody ViajeDto viajeDto) {
        ViajeDto nuevoViaje = viajeService.crearviaje(viajeDto);
        return ResponseEntity.ok(nuevoViaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViajeDto> obtenerViajesPorId(@PathVariable Long id) {
        ViajeDto viaje = viajeService.obtenerViajesPorId(id);
        return ResponseEntity.ok(viaje);
    }

    @GetMapping
    public ResponseEntity<List<ViajeDto>> obtenerTodosLosviajes() {
        List<ViajeDto> viajes = viajeService.obtenerTodosLosviajes();
        return ResponseEntity.ok(viajes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViajeDto> actualizarUsuario(@PathVariable Long id, @RequestBody ViajeDto viajeDto) {
        ViajeDto usuarioActualizado = viajeService.actualizarUsuario(id, viajeDto);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarViajes(@PathVariable Long id) {
        viajeService.eliminarViajes(id);
        return ResponseEntity.noContent().build();
    }
}
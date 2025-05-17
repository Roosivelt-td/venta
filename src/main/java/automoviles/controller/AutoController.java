package automoviles.controller;

import automoviles.dto.AutoDTO;
import automoviles.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/autos")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @PostMapping
    public ResponseEntity<AutoDTO> crearAuto(@RequestBody AutoDTO autoDTO) {
        AutoDTO nuevoAuto = autoService.crearAuto(autoDTO);
        return ResponseEntity.ok(nuevoAuto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoDTO> obtenerAutoPorId(@PathVariable Long id) {
        AutoDTO auto = autoService.obtenerAutoPorId(id);
        return ResponseEntity.ok(auto);
    }

    @GetMapping
    public ResponseEntity<List<AutoDTO>> obtenerTodosLosAutos() {
        List<AutoDTO> autos = autoService.obtenerTodosLosAutos();
        return ResponseEntity.ok(autos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoDTO> actualizarAuto(@PathVariable Long id, @RequestBody AutoDTO autoDTO) {
        AutoDTO autoActualizado = autoService.actualizarAuto(id, autoDTO);
        return ResponseEntity.ok(autoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAuto(@PathVariable Long id) {
        autoService.eliminarAuto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<AutoDTO>> buscarPorMarca(@PathVariable String marca) {
        List<AutoDTO> autos = autoService.buscarPorMarca(marca);
        return ResponseEntity.ok(autos);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<AutoDTO>> buscarPorEstado(@PathVariable String estado) {
        List<AutoDTO> autos = autoService.buscarPorEstado(estado);
        return ResponseEntity.ok(autos);
    }
}
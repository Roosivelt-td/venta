package automoviles.controller;

import automoviles.dto.ProveedorDTO;
import automoviles.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<ProveedorDTO> crearProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        ProveedorDTO nuevoProveedor = proveedorService.crearProveedor(proveedorDTO);
        return ResponseEntity.ok(nuevoProveedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> obtenerProveedorPorId(@PathVariable Long id) {
        ProveedorDTO proveedor = proveedorService.obtenerProveedorPorId(id);
        return ResponseEntity.ok(proveedor);
    }

    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> obtenerTodosLosProveedores() {
        List<ProveedorDTO> proveedores = proveedorService.obtenerTodosLosProveedores();
        return ResponseEntity.ok(proveedores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> actualizarProveedor(@PathVariable Long id, @RequestBody ProveedorDTO proveedorDTO) {
        ProveedorDTO proveedorActualizado = proveedorService.actualizarProveedor(id, proveedorDTO);
        return ResponseEntity.ok(proveedorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
package automoviles.controller;

import automoviles.dto.ReembolsoDTO;
import automoviles.service.ReembolsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reembolsos")
public class ReembolsoController {

    @Autowired
    private ReembolsoService reembolsoService;

    @PostMapping
    public ResponseEntity<ReembolsoDTO> crearReembolso(@RequestBody ReembolsoDTO reembolsoDTO) {
        ReembolsoDTO nuevoReembolso = reembolsoService.crearReembolso(reembolsoDTO);
        return ResponseEntity.ok(nuevoReembolso);
    }

    @GetMapping("/venta/{ventaId}")
    public ResponseEntity<List<ReembolsoDTO>> obtenerReembolsosPorVenta(@PathVariable Long ventaId) {
        List<ReembolsoDTO> reembolsos = reembolsoService.obtenerReembolsosPorVenta(ventaId);
        return ResponseEntity.ok(reembolsos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReembolso(@PathVariable Long id) {
        reembolsoService.eliminarReembolso(id);
        return ResponseEntity.noContent().build();
    }
}
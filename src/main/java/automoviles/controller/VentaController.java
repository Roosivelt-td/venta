package automoviles.controller;

import automoviles.dto.VentaDTO;
import automoviles.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public ResponseEntity<VentaDTO> crearVenta(@RequestBody VentaDTO ventaDTO) {
        VentaDTO nuevaVenta = ventaService.crearVenta(ventaDTO);
        return ResponseEntity.ok(nuevaVenta);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<VentaDTO>> obtenerVentasPorCliente(@PathVariable Long clienteId) {
        List<VentaDTO> ventas = ventaService.obtenerVentasPorCliente(clienteId);
        return ResponseEntity.ok(ventas);
    }

    // Otros endpoints (GET /api/ventas, GET /api/ventas/auto/{autoId}, etc.)
    // ...
}
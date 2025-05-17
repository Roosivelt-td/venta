package automoviles.controller;

import automoviles.dto.PagoDTO;
import automoviles.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoDTO> crearPago(@RequestBody PagoDTO pagoDTO) {
        PagoDTO nuevoPago = pagoService.crearPago(pagoDTO);
        return ResponseEntity.ok(nuevoPago);
    }

    @GetMapping("/venta/{ventaId}")
    public ResponseEntity<List<PagoDTO>> obtenerPagosPorVenta(@PathVariable Long ventaId) {
        List<PagoDTO> pagos = pagoService.obtenerPagosPorVenta(ventaId);
        return ResponseEntity.ok(pagos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {
        pagoService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }
}
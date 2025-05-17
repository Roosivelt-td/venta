package automoviles.controller;

import automoviles.dto.CompraDTO;
import automoviles.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<CompraDTO> crearCompra(@RequestBody CompraDTO compraDTO) {
        CompraDTO nuevaCompra = compraService.crearCompra(compraDTO);
        return ResponseEntity.ok(nuevaCompra);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> obtenerCompraPorId(@PathVariable Long id) {
        CompraDTO compra = compraService.obtenerCompraPorId(id);
        return ResponseEntity.ok(compra);
    }

    @GetMapping
    public ResponseEntity<List<CompraDTO>> obtenerTodasLasCompras() {
        List<CompraDTO> compras = compraService.obtenerTodasLasCompras();
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/proveedor/{proveedorId}")
    public ResponseEntity<List<CompraDTO>> obtenerComprasPorProveedor(@PathVariable Long proveedorId) {
        List<CompraDTO> compras = compraService.obtenerComprasPorProveedor(proveedorId);
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/auto/{autoId}")
    public ResponseEntity<List<CompraDTO>> obtenerComprasPorAuto(@PathVariable Long autoId) {
        List<CompraDTO> compras = compraService.obtenerComprasPorAuto(autoId);
        return ResponseEntity.ok(compras);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCompra(@PathVariable Long id) {
        compraService.eliminarCompra(id);
        return ResponseEntity.noContent().build();
    }
}
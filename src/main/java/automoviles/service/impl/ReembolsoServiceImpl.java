package automoviles.service.impl;

import automoviles.dto.ReembolsoDTO;
import automoviles.model.*;
import automoviles.repository.*;
import automoviles.service.ReembolsoService;
import automoviles.service.mapper.ReembolsoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReembolsoServiceImpl implements ReembolsoService {

    @Autowired
    private ReembolsoRepository reembolsoRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ReembolsoMapper reembolsoMapper;

    @Override
    public ReembolsoDTO crearReembolso(ReembolsoDTO reembolsoDTO) {
        Venta venta = ventaRepository.findById(reembolsoDTO.getIdVenta())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        // Validación adicional: Verificar que la venta no esté ya reembolsada
        if (reembolsoRepository.existsByVentaId(venta.getId())) {
            throw new RuntimeException("Ya existe un reembolso para esta venta");
        }

        Reembolso reembolso = reembolsoMapper.toEntity(reembolsoDTO, venta);
        reembolso = reembolsoRepository.save(reembolso);
        return reembolsoMapper.toDto(reembolso);
    }

    @Override
    public List<ReembolsoDTO> obtenerReembolsosPorVenta(Long ventaId) {
        return reembolsoRepository.findByVentaId(ventaId).stream()
                .map(reembolsoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarReembolso(Long id) {
        reembolsoRepository.deleteById(id);
    }
}
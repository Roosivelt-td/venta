package automoviles.service.impl;

import automoviles.dto.PagoDTO;
import automoviles.model.*;
import automoviles.repository.*;
import automoviles.service.PagoService;
import automoviles.service.mapper.PagoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private PagoMapper pagoMapper;

    @Override
    public PagoDTO crearPago(PagoDTO pagoDTO) {
        Venta venta = ventaRepository.findById(pagoDTO.getIdVenta())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        Pago pago = pagoMapper.toEntity(pagoDTO, venta);
        pago = pagoRepository.save(pago);
        return pagoMapper.toDto(pago);
    }

    @Override
    public List<PagoDTO> obtenerPagosPorVenta(Long ventaId) {
        return pagoRepository.findByVentaId(ventaId).stream()
                .map(pagoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }
}
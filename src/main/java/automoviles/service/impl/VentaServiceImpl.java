package automoviles.service.impl;

import automoviles.dto.VentaDTO;
import automoviles.model.*;
import automoviles.repository.*;
import automoviles.service.VentaService;
import automoviles.service.mapper.VentaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VentaMapper ventaMapper;

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDTO) {
        Cliente cliente = clienteRepository.findById(ventaDTO.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Auto auto = autoRepository.findById(ventaDTO.getIdAuto())
                .orElseThrow(() -> new RuntimeException("Auto no encontrado"));
        Usuario usuario = usuarioRepository.findById(ventaDTO.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!auto.getEstado().equals(Auto.Estado.disponible)) {
            throw new RuntimeException("El auto no está disponible para la venta");
        }

        Venta venta = ventaMapper.toEntity(ventaDTO, cliente, auto, usuario);
        venta = ventaRepository.save(venta);

        auto.setEstado(Auto.Estado.vendido);
        autoRepository.save(auto);

        return ventaMapper.toDto(venta);
    }

    @Override
    public VentaDTO obtenerVentaPorId(Long id) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        return ventaMapper.toDto(venta);
    }

    @Override
    public List<VentaDTO> obtenerTodasLasVentas() {
        return ventaRepository.findAll().stream()
                .map(ventaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VentaDTO> obtenerVentasPorCliente(Long clienteId) {
        return ventaRepository.findByClienteId(clienteId).stream()
                .map(ventaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VentaDTO> obtenerVentasPorAuto(Long autoId) {
        return ventaRepository.findByAutoId(autoId).stream()
                .map(ventaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VentaDTO> obtenerVentasPorUsuario(Long usuarioId) {
        return ventaRepository.findByUsuarioId(usuarioId).stream()
                .map(ventaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarVenta(Long id) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        // Opcional: Restaurar el estado del auto a "disponible" al eliminar la venta
        Auto auto = venta.getAuto();
        auto.setEstado(Auto.Estado.disponible);
        autoRepository.save(auto);

        ventaRepository.deleteById(id);
    }
}
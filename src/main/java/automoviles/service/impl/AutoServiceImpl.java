package automoviles.service.impl;

import automoviles.dto.AutoDTO;
import automoviles.model.Auto;
import automoviles.repository.AutoRepository;
import automoviles.service.AutoService;
import automoviles.service.mapper.AutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private AutoMapper autoMapper;

    @Override
    public AutoDTO crearAuto(AutoDTO autoDTO) {
        Auto auto = autoMapper.toEntity(autoDTO);
        auto = autoRepository.save(auto);
        return autoMapper.toDto(auto);
    }

    @Override
    public AutoDTO obtenerAutoPorId(Long id) {
        Auto auto = autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto no encontrado"));
        return autoMapper.toDto(auto);
    }

    @Override
    public List<AutoDTO> obtenerTodosLosAutos() {
        return autoRepository.findAll().stream()
                .map(autoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AutoDTO actualizarAuto(Long id, AutoDTO autoDTO) {
        Auto auto = autoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto no encontrado"));
        auto.setMarca(autoDTO.getMarca());
        auto.setModelo(autoDTO.getModelo());
        auto.setAnio(autoDTO.getAnio());
        auto.setColor(autoDTO.getColor());
        auto.setKilometraje(autoDTO.getKilometraje());
        auto.setTipo(autoDTO.getTipo());
        auto.setPrecio(autoDTO.getPrecio());
        auto.setDescripcion(autoDTO.getDescripcion());
        auto.setImagenUrl(autoDTO.getImagenUrl());
        auto.setEstado(autoDTO.getEstado());
        auto = autoRepository.save(auto);
        return autoMapper.toDto(auto);
    }

    @Override
    public void eliminarAuto(Long id) {
        autoRepository.deleteById(id);
    }

    @Override
    public List<AutoDTO> buscarPorMarca(String marca) {
        return autoRepository.findByMarca(marca).stream()
                .map(autoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoDTO> buscarPorEstado(String estado) {
        Auto.Estado estadoEnum = Auto.Estado.valueOf(estado);
        return autoRepository.findByEstado(estadoEnum).stream()
                .map(autoMapper::toDto)
                .collect(Collectors.toList());
    }
}
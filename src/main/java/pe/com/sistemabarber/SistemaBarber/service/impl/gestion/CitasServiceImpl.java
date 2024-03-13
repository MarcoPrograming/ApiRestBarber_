/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.sistemabarber.SistemaBarber.service.impl.gestion;

/**
 *
 * @author USUARIO
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.CitasDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CitasEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.CitasRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import pe.com.sistemabarber.SistemaBarber.service.gestion.CitasService;

@Service
public class CitasServiceImpl implements CitasService {

    @Autowired
    private CitasRepository citasRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CitasDTO> findAll() {
        List<CitasEntity> citasEntities = citasRepository.findAll();
        return citasEntities.stream()
                .map(citasEntity -> mapper.map(citasEntity, CitasDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CitasDTO findById(Long id) {
        Optional<CitasEntity> citaOptional = citasRepository.findById(id);
        if (citaOptional.isPresent()) {
            CitasEntity citaEntity = citaOptional.get();
            return mapper.map(citaEntity, CitasDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public CitasDTO guardar(CitasDTO citaDTO) {
        CitasEntity citaEntity = mapper.map(citaDTO, CitasEntity.class);
        citaEntity.setFechaRegistro(LocalDateTime.now());
        return mapper.map(citasRepository.save(citaEntity), CitasDTO.class);
    }

    @Override
    public CitasDTO actualizar(CitasDTO citaDTO, Long id) {
        Optional<CitasEntity> citaOptional = citasRepository.findById(id);
        if (citaOptional.isPresent()) {
            CitasEntity citaEntity = citaOptional.get();
            citaEntity.setFechaRegistro(LocalDateTime.now());
            return mapper.map(citasRepository.save(citaEntity), CitasDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public CitasDTO delete(Long id) {
        Optional<CitasEntity> citaOptional = citasRepository.findById(id);
        if (citaOptional.isPresent()) {
            CitasEntity citaEntity = citaOptional.get();
            citasRepository.delete(citaEntity);
            return mapper.map(citaEntity, CitasDTO.class);
        } else {
            return null;
        }
    }
}

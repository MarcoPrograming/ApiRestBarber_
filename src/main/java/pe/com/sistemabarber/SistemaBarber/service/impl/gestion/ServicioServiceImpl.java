package pe.com.sistemabarber.SistemaBarber.service.impl.gestion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.ServicioDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.ServicioEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.ServicioRepository;
import pe.com.sistemabarber.SistemaBarber.service.gestion.ServicioService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<ServicioDTO> findAll() {
        List<ServicioEntity> servicioEntities = servicioRepository.findAll();
        return servicioEntities.stream()
                .map(servicioEntity -> mapper.map(servicioEntity, ServicioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ServicioDTO findById(Long id) {
        Optional<ServicioEntity> servicioOptional = servicioRepository.findById(id);
        return servicioOptional.map(servicioEntity -> mapper.map(servicioEntity, ServicioDTO.class)).orElse(null);
    }

    @Override
    public ServicioDTO guardar(ServicioDTO servicioDTO) {
        ServicioEntity servicioEntity = mapper.map(servicioDTO, ServicioEntity.class);
        servicioEntity.setFecha_creacion(LocalDateTime.now());
        servicioEntity.setFecha_actualizacion(LocalDateTime.now());
        return mapper.map(servicioRepository.save(servicioEntity), ServicioDTO.class);
    }

    @Override
    public ServicioDTO actualizar(ServicioDTO servicioDTO, Long id) {
        Optional<ServicioEntity> servicioOptional = servicioRepository.findById(id);
        if (servicioOptional.isPresent()) {
            ServicioEntity servicioEntity = servicioOptional.get();
            servicioEntity.setNombre(servicioDTO.getNombre());
            servicioEntity.setPrecio(servicioDTO.getPrecio());
            servicioEntity.setEstado(servicioDTO.getEstado());
            servicioEntity.setFecha_actualizacion(LocalDateTime.now());
            return mapper.map(servicioRepository.save(servicioEntity), ServicioDTO.class);
        } else {
            throw new RuntimeException("Servicio no encontrado");
        }
    }

    @Override
    public ServicioDTO delete(Long id) {
        Optional<ServicioEntity> servicioOptional = servicioRepository.findById(id);
        if (servicioOptional.isPresent()) {
            ServicioEntity servicioEntity = servicioOptional.get();
            servicioRepository.delete(servicioEntity);
            return mapper.map(servicioEntity, ServicioDTO.class);
        } else {
            throw new RuntimeException("Servicio no encontrado");
        }
    }
}

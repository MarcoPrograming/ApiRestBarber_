package pe.com.sistemabarber.SistemaBarber.service.impl.proceso;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.proceso.CitasServiciosDTO;
import pe.com.sistemabarber.SistemaBarber.models.proceso.DetalleCitasServiciosEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.ServicioEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.CitasRepository;
import pe.com.sistemabarber.SistemaBarber.repository.proceso.DetalleCitasServiciosRepository;
import pe.com.sistemabarber.SistemaBarber.service.proceso.DetalleCitasServiciosService;

@Service
public class DetalleCitasServiciosServiceImpl implements DetalleCitasServiciosService {

    @Autowired
    private DetalleCitasServiciosRepository citasServiciosRepository;

    @Autowired
    private CitasRepository citasRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CitasServiciosDTO> findAll() {
        List<DetalleCitasServiciosEntity> citasServiciosEntities = citasServiciosRepository.findAll();
        return citasServiciosEntities.stream()
                .map(citasServiciosEntity -> mapper.map(citasServiciosEntity, CitasServiciosDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CitasServiciosDTO findById(Long id) {
        Optional<DetalleCitasServiciosEntity> citasServiciosEntityOptional = citasServiciosRepository.findById(id);
        return citasServiciosEntityOptional.map(entity -> mapper.map(entity, CitasServiciosDTO.class)).orElse(null);
    }

@Override
public CitasServiciosDTO guardar(CitasServiciosDTO citasServiciosDTO) {
    if (citasServiciosDTO.getCita().getId() == null) {
        throw new IllegalArgumentException("La cita asociada no tiene un ID válido.");
    }

    DetalleCitasServiciosEntity citasServiciosEntity = mapper.map(citasServiciosDTO, DetalleCitasServiciosEntity.class);

    Long citaId = citasServiciosDTO.getCita().getId(); // Crear una copia final de la variable citaId

    citasRepository.findById(citaId).ifPresentOrElse(citasServiciosEntity::setCita,
        () -> {
            throw new IllegalArgumentException("No se puede guardar el detalle de cita. La cita asociada no existe.");
        }
    );

    citasServiciosEntity = citasServiciosRepository.save(citasServiciosEntity);

    return mapper.map(citasServiciosEntity, CitasServiciosDTO.class);
}



    @Override
    public CitasServiciosDTO actualizar(CitasServiciosDTO citasServiciosDTO, Long id) {
        Optional<DetalleCitasServiciosEntity> citaServicioOptional = citasServiciosRepository.findById(id);
        if (citaServicioOptional.isPresent()) {
            DetalleCitasServiciosEntity citaServicio = citaServicioOptional.get();
            citaServicio.setServicio(mapper.map(citasServiciosDTO.getServicio(), ServicioEntity.class));
            // citaServicio.setCita(mapper.map(citasServiciosDTO.getCita(), CitasEntity.class)); // No es necesario actualizar la cita aquí
            citaServicio.setDuracion(citasServiciosDTO.getDuracion());
            citaServicio.setTotal(citasServiciosDTO.getTotal());
            citaServicio.setComentarios(citasServiciosDTO.getComentarios());
            return mapper.map(citasServiciosRepository.save(citaServicio), CitasServiciosDTO.class);
        } else {
            throw new RuntimeException("Detalle de cita no encontrado");
        }
    }

    @Override
    public CitasServiciosDTO delete(Long id) {
        Optional<DetalleCitasServiciosEntity> citaServicioOptional = citasServiciosRepository.findById(id);
        if (citaServicioOptional.isPresent()) {
            citasServiciosRepository.delete(citaServicioOptional.get());
            return null;
        } else {
            throw new RuntimeException("Detalle de cita no encontrado");
        }
    }
}

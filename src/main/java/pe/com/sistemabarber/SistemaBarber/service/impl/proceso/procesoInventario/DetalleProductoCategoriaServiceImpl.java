package pe.com.sistemabarber.SistemaBarber.service.impl.proceso.procesoInventario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.proceso.procesoInventario.DetalleProductoCategoriaDTO;
import pe.com.sistemabarber.SistemaBarber.models.proceso.procesoInventario.DetalleProductoCategoriaEntity;
import pe.com.sistemabarber.SistemaBarber.repository.proceso.procesoInventario.DetalleProductoCategoriaRepository;
import pe.com.sistemabarber.SistemaBarber.service.proceso.procesoInventario.DetalleProductoCategoriaService;

/**
 *
 * @author ACER
 */
@Service
public class DetalleProductoCategoriaServiceImpl  implements DetalleProductoCategoriaService {
    
    @Autowired
    private DetalleProductoCategoriaRepository repositorio;


    @Autowired
    private ModelMapper mapper;

    @Override
    public List<DetalleProductoCategoriaDTO> findAll() {
        List<DetalleProductoCategoriaEntity> detalle = repositorio.findAll();
        return detalle.stream()
                .map(citasServiciosEntity -> mapper.map(citasServiciosEntity, DetalleProductoCategoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DetalleProductoCategoriaDTO findById(Long id) {
        Optional<DetalleProductoCategoriaEntity> citasServiciosEntityOptional = repositorio.findById(id);
        return citasServiciosEntityOptional.map(entity -> mapper.map(entity, DetalleProductoCategoriaDTO.class)).orElse(null);
    }

@Override
public DetalleProductoCategoriaDTO guardar(DetalleProductoCategoriaDTO detalleDTO) {

    DetalleProductoCategoriaEntity detalle = mapper.map(detalleDTO, DetalleProductoCategoriaEntity.class);

        return mapper.map(repositorio.save(detalle), 
               DetalleProductoCategoriaDTO.class);

}



    @Override
    public DetalleProductoCategoriaDTO actualizar(DetalleProductoCategoriaDTO t, Long id) {
        DetalleProductoCategoriaEntity detalle = repositorio.findById(id).get();
        mapper.map(t, detalle);
        return mapper.map(repositorio.save(detalle), DetalleProductoCategoriaDTO.class);


    }

    @Override
    public DetalleProductoCategoriaDTO delete(Long id) {
        Optional<DetalleProductoCategoriaEntity> detalle = repositorio.findById(id);
        if (detalle.isPresent()) {
            repositorio.delete(detalle.get());
            return null;
        } else {
            throw new RuntimeException("Detalle no encontrado");
        }
    }
}



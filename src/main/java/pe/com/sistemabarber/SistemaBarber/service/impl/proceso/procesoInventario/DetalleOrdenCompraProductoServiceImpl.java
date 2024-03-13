package pe.com.sistemabarber.SistemaBarber.service.impl.proceso.procesoInventario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.proceso.procesoInventario.DetalleOrdenCompraProductoDTO;
import pe.com.sistemabarber.SistemaBarber.models.proceso.procesoInventario.DetalleOrdenCompraProductoEntity;
import pe.com.sistemabarber.SistemaBarber.repository.proceso.procesoInventario.DetalleOrdenCompraProductoRepository;
import pe.com.sistemabarber.SistemaBarber.service.proceso.procesoInventario.DetalleOrdenCompraProductoService;

/**
 *
 * @author ACER
 */
@Service
public class DetalleOrdenCompraProductoServiceImpl implements DetalleOrdenCompraProductoService {
    
    @Autowired
    private DetalleOrdenCompraProductoRepository repositorio;


    @Autowired
    private ModelMapper mapper;

    @Override
    public List<DetalleOrdenCompraProductoDTO> findAll() {
        List<DetalleOrdenCompraProductoEntity> detalle = repositorio.findAll();
        return detalle.stream()
                .map(citasServiciosEntity -> mapper.map(citasServiciosEntity, DetalleOrdenCompraProductoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DetalleOrdenCompraProductoDTO findById(Long id) {
        Optional<DetalleOrdenCompraProductoEntity> citasServiciosEntityOptional = repositorio.findById(id);
        return citasServiciosEntityOptional.map(entity -> mapper.map(entity, DetalleOrdenCompraProductoDTO.class)).orElse(null);
    }

@Override
public DetalleOrdenCompraProductoDTO guardar(DetalleOrdenCompraProductoDTO detalleDTO) {

    DetalleOrdenCompraProductoEntity detalle = mapper.map(detalleDTO, DetalleOrdenCompraProductoEntity.class);

        return mapper.map(repositorio.save(detalle), 
               DetalleOrdenCompraProductoDTO.class);

}



    @Override
    public DetalleOrdenCompraProductoDTO actualizar(DetalleOrdenCompraProductoDTO t, Long id) {
        DetalleOrdenCompraProductoEntity detalle = repositorio.findById(id).get();
        mapper.map(t, detalle);
        return mapper.map(repositorio.save(detalle), DetalleOrdenCompraProductoDTO.class);


    }

    @Override
    public DetalleOrdenCompraProductoDTO delete(Long id) {
        Optional<DetalleOrdenCompraProductoEntity> detalle = repositorio.findById(id);
        if (detalle.isPresent()) {
            repositorio.delete(detalle.get());
            return null;
        } else {
            throw new RuntimeException("Detalle no encontrado");
        }
    }
}


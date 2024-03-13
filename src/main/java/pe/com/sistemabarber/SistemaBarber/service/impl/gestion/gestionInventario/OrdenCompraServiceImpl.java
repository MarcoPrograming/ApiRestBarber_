package pe.com.sistemabarber.SistemaBarber.service.impl.gestion.gestionInventario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.OrdenCompraDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CargoEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.OrdenCompraEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.gestionInventario.OrdenCompraRepository;
import pe.com.sistemabarber.SistemaBarber.service.gestion.gestionInventario.OrdenCompraService;

/**
 *
 * @author ACER
 */
@Service

public class OrdenCompraServiceImpl implements OrdenCompraService{
        @Autowired
    private final OrdenCompraRepository repositorio;

    public OrdenCompraServiceImpl(OrdenCompraRepository re) {
        this.repositorio = re;
    }
    
       @Autowired 
    private ModelMapper mapper;



    @Override
    public OrdenCompraDTO guardar(OrdenCompraDTO ordendto) {
        OrdenCompraEntity orden = mapper.map(ordendto, OrdenCompraEntity.class);
        orden.setFecha_creacion(LocalDateTime.now());
        orden.setFecha_actualizacion(LocalDateTime.now());
        return mapper.map(repositorio.save(orden), OrdenCompraDTO.class);
    }
    
        @Override
    public List<OrdenCompraDTO> findAll() {
               List<OrdenCompraEntity> lista = repositorio.findAll();
        return lista.stream().
                map(c -> mapper.map(c, OrdenCompraDTO.class))
                .collect(Collectors.toList());
    }

    
        @Override
    public OrdenCompraDTO findById(Long id) {
              OrdenCompraEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, 
                OrdenCompraDTO.class);

    }
    
        @Override
    public OrdenCompraDTO actualizar(OrdenCompraDTO t, Long id) {
             OrdenCompraEntity orden = repositorio.findById(id).get();
             
             orden.setFecha_actualizacion(LocalDateTime.now());
        mapper.map(t, orden);
        return mapper.map(repositorio.save(orden), OrdenCompraDTO.class);

    }

    
    @Override
    public OrdenCompraDTO delete(Long id) {
        OrdenCompraEntity orden = repositorio.findById(id).get();
        orden.setEstado("I");
        return mapper.map(repositorio.save(orden), OrdenCompraDTO.class);

    }

    
}

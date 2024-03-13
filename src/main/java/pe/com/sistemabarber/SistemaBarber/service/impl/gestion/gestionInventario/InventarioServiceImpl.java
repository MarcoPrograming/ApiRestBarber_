package pe.com.sistemabarber.SistemaBarber.service.impl.gestion.gestionInventario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.InventarioDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CargoEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.InventarioEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.gestionInventario.InventarioRepository;
import pe.com.sistemabarber.SistemaBarber.service.gestion.gestionInventario.InventarioService;

/**
 *
 * @author ACER
 */
@Service
public class InventarioServiceImpl implements InventarioService{
     @Autowired
    private final InventarioRepository repositorio;
    
    
        @Autowired 
    private ModelMapper mapper;

    public InventarioServiceImpl() {
        this.repositorio = null;
    }


    @Override
    public InventarioDTO guardar(InventarioDTO inventariodto) {
        InventarioEntity inventario = mapper.map(inventariodto, InventarioEntity.class);
        inventario.setFecha_creacion(LocalDateTime.now());
        inventario.setFecha_actualizacion(LocalDateTime.now());
        return mapper.map(repositorio.save(inventario), InventarioDTO.class);
    }
    
        @Override
    public List<InventarioDTO> findAll() {
               List<InventarioEntity> lista = repositorio.findAll();
        return lista.stream().
                map(c -> mapper.map(c, InventarioDTO.class))
                .collect(Collectors.toList());
    }
    
        @Override
    public InventarioDTO findById(Long id) {
              InventarioEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, 
                InventarioDTO.class);

    }
    
        @Override
    public InventarioDTO actualizar(InventarioDTO t, Long id) {
             InventarioEntity inventario = repositorio.findById(id).get();
        mapper.map(t, inventario);
        return mapper.map(repositorio.save(inventario), InventarioDTO.class);

    }

        @Override
    public InventarioDTO delete(Long id) {
        InventarioEntity inventario = repositorio.findById(id).get();
        inventario.setEstado("I");
        return mapper.map(repositorio.save(inventario), InventarioDTO.class);

    }

    


    
    
    


    
    
}




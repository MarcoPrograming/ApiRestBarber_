package pe.com.sistemabarber.SistemaBarber.service.impl.gestion.gestionInventario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.ProductoDTO;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.ProveedorDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.ProveedorEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.gestionInventario.ProveedorRepository;
import pe.com.sistemabarber.SistemaBarber.service.gestion.gestionInventario.ProveedorService;

/**
 *
 * @author ACER
 */
@Service
public class ProveedorServiceImpl  implements ProveedorService{
          @Autowired
    private final ProveedorRepository repositorio;

    public ProveedorServiceImpl(ProveedorRepository re) {
        this.repositorio = re;
    }
    
       @Autowired 
    private ModelMapper mapper;



    @Override
    public ProveedorDTO guardar(ProveedorDTO ordendto) {
        ProveedorEntity orden = mapper.map(ordendto, ProveedorEntity.class);
        orden.setFecha_creacion(LocalDateTime.now());
        orden.setFecha_actualizacion(LocalDateTime.now());
        return mapper.map(repositorio.save(orden), ProveedorDTO.class);
    }
    
        @Override
    public List<ProveedorDTO> findAll() {
               List<ProveedorEntity> lista = repositorio.findAll();
        return lista.stream().
                map(c -> mapper.map(c, ProveedorDTO.class))
                .collect(Collectors.toList());
    }

    
        @Override
    public ProveedorDTO findById(Long id) {
              ProveedorEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, 
                ProveedorDTO.class);

    }
    
        @Override
    public ProveedorDTO actualizar(ProveedorDTO t, Long id) {
             ProveedorEntity producto = repositorio.findById(id).get();
        mapper.map(t, producto);
        return mapper.map(repositorio.save(producto), ProveedorDTO.class);

    }

    
    @Override
    public ProveedorDTO delete(Long id) {
        ProveedorEntity producto = repositorio.findById(id).get();
        producto.setEstado("I");
        return mapper.map(repositorio.save(producto), ProveedorDTO.class);

    }

    
}

  


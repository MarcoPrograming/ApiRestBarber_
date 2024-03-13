package pe.com.sistemabarber.SistemaBarber.service.impl.gestion.gestionInventario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.CategoriaProductoDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.CategoriaProductoEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.gestionInventario.CategoriaProductoRepository;
import pe.com.sistemabarber.SistemaBarber.service.gestion.gestionInventario.CategoriaProductoService;

/**
 *
 * @author ACER
 */
@Service
public class CategoriaProductoServiceImpl  implements CategoriaProductoService {
    
      @Autowired
    private CategoriaProductoRepository repositorio;
      
        @Autowired 
    private ModelMapper mapper;
        
            @Override
    public List<CategoriaProductoDTO> findAll() {
        List<CategoriaProductoEntity> lista = repositorio.findAll();
        return lista.stream().
                map(c -> mapper.map(c, CategoriaProductoDTO.class))
                .collect(Collectors.toList());
    }
    
        @Override
    public CategoriaProductoDTO guardar(CategoriaProductoDTO empleadoDTO) {
        CategoriaProductoEntity categoria = mapper.map(empleadoDTO, CategoriaProductoEntity.class);
        categoria.setFecha_creacion(LocalDateTime.now());
        categoria.setFecha_actualizacion(LocalDateTime.now());
        return mapper.map(repositorio.save(categoria), CategoriaProductoDTO.class);
    }

        @Override
    public CategoriaProductoDTO actualizar(CategoriaProductoDTO categoriaDto, Long id) {
        Optional<CategoriaProductoEntity> categoriaOptional = repositorio.findById(id);
        if (categoriaOptional.isPresent()) {
            CategoriaProductoEntity categoria = categoriaOptional.get();
            mapper.map(categoriaDto, categoria);
            categoria.setFecha_actualizacion(LocalDateTime.now());
            return mapper.map(repositorio.save(categoria), CategoriaProductoDTO.class);
        } else {
            throw new RuntimeException("Categoria Producto no encontrado");
        }
    }

        @Override
    public CategoriaProductoDTO findById(Long id) {
        Optional<CategoriaProductoEntity> categoriaOptional = repositorio.findById(id);
        if (categoriaOptional.isPresent()) {
            CategoriaProductoEntity categoriaEntity = categoriaOptional.get();
            return mapper.map(categoriaEntity, CategoriaProductoDTO.class);
        } else {
 
            return null;  
        }
    }

 

    @Override
    public CategoriaProductoDTO delete(Long id) {
        CategoriaProductoEntity cargo = repositorio.findById(id).get();
        cargo.setEstado("I");
        return mapper.map(repositorio.save(cargo), CategoriaProductoDTO.class);

    }


    


    
}

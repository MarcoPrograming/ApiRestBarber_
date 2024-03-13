package pe.com.sistemabarber.SistemaBarber.service.impl.gestion.gestionInventario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.ProductoDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.ProductoEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.gestionInventario.ProductoRepository;
import pe.com.sistemabarber.SistemaBarber.service.gestion.gestionInventario.ProductoService;

/**
 *
 * @author ACER
 */
@Service
public class ProductoServiceImpl  implements ProductoService{
    
        @Autowired
    private final ProductoRepository repositorio;

    public ProductoServiceImpl(ProductoRepository re) {
        this.repositorio = re;
    }
    
       @Autowired 
    private ModelMapper mapper;



    @Override
    public ProductoDTO guardar(ProductoDTO ordendto) {
        ProductoEntity orden = mapper.map(ordendto, ProductoEntity.class);
        orden.setFecha_creacion(LocalDateTime.now());
        orden.setFecha_actualizacion(LocalDateTime.now());
        return mapper.map(repositorio.save(orden), ProductoDTO.class);
    }
    
        @Override
    public List<ProductoDTO> findAll() {
               List<ProductoEntity> lista = repositorio.findAll();
        return lista.stream().
                map(c -> mapper.map(c, ProductoDTO.class))
                .collect(Collectors.toList());
    }

    
        @Override
    public ProductoDTO findById(Long id) {
              ProductoEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, 
                ProductoDTO.class);

    }
    
        @Override
    public ProductoDTO actualizar(ProductoDTO t, Long id) {
             ProductoEntity producto = repositorio.findById(id).get();
        mapper.map(t, producto);
        return mapper.map(repositorio.save(producto), ProductoDTO.class);

    }

    
    @Override
    public ProductoDTO delete(Long id) {
        ProductoEntity producto = repositorio.findById(id).get();
        producto.setEstado("I");
        return mapper.map(repositorio.save(producto), ProductoDTO.class);

    }

    
}


package pe.com.sistemabarber.SistemaBarber.repository.gestion.gestionInventario;

import java.util.Optional;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.ProductoEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;

/**
 *
 * @author ACER
 */
public interface ProductoRepository  extends BaseRepository<ProductoEntity, Long >{
            Optional<ProductoEntity> findByNombre(String nombre);

}

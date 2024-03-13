package pe.com.sistemabarber.SistemaBarber.repository.gestion.gestionInventario;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.InventarioEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;

/**
 *
 * @author ACER
 */
@Repository
public interface InventarioRepository  extends BaseRepository<InventarioEntity,Long>{
        Optional<InventarioEntity> findByNombre(String nombre);

}


package pe.com.sistemabarber.SistemaBarber.repository.gestion.gestionInventario;

import java.util.Optional;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.ProveedorEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;

/**
 *
 * @author ACER
 */
public interface ProveedorRepository extends BaseRepository<ProveedorEntity, Long > {
                Optional<ProveedorEntity> findByNombre(String nombre);

}

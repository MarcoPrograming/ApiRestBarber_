package pe.com.sistemabarber.SistemaBarber.repository.gestion.gestionInventario;

import org.springframework.stereotype.Repository;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.OrdenCompraEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;

/**
 *
 * @author ACER
 */
@Repository
public interface OrdenCompraRepository extends BaseRepository<OrdenCompraEntity, Long > {
    
}

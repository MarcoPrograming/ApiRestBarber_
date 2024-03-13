package pe.com.sistemabarber.SistemaBarber.repository.gestion.gestionInventario;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.CategoriaProductoEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;

/**
 *
 * @author ACER
 */
@Repository
public interface CategoriaProductoRepository  extends BaseRepository<CategoriaProductoEntity,Long> {
 Optional<CategoriaProductoEntity> findByNombre(String nombre);
}

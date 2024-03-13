package pe.com.sistemabarber.SistemaBarber.repository.gestion;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import pe.com.sistemabarber.SistemaBarber.models.gestion.HorarioDisponibleEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;

/**
 *
 * @author ACER
 */
@Repository
public interface HorarioDisponibleRepository extends BaseRepository<HorarioDisponibleEntity, Long >{
        Optional<HorarioDisponibleEntity> findByNombre(String nombre);

}

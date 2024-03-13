package pe.com.sistemabarber.SistemaBarber.repository.gestion;

import org.springframework.stereotype.Repository;
import pe.com.sistemabarber.SistemaBarber.models.gestion.ServicioEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;

@Repository
public interface ServicioRepository extends BaseRepository<ServicioEntity, Long> {
}

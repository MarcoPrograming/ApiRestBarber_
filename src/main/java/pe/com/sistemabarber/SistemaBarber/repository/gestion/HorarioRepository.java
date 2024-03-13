package pe.com.sistemabarber.SistemaBarber.repository.gestion;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import pe.com.sistemabarber.SistemaBarber.models.gestion.HorarioEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;


@Repository
public interface HorarioRepository extends BaseRepository<HorarioEntity, Long >{

    Optional<HorarioEntity> findByNombre(String nombre);


}

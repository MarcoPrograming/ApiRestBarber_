package pe.com.sistemabarber.SistemaBarber.repository.gestion;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.CargoDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CargoEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;

@Repository
public interface CargoRepository  extends BaseRepository<CargoEntity, Long>{

     Optional<CargoEntity> findByNombre(String nombre);

}

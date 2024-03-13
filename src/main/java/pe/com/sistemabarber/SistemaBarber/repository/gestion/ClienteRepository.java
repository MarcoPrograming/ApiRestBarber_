package pe.com.sistemabarber.SistemaBarber.repository.gestion;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import pe.com.sistemabarber.SistemaBarber.models.gestion.ClienteEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;




@Repository
public interface ClienteRepository extends BaseRepository<ClienteEntity, Long > {

    Optional<ClienteEntity> findByNombresAndApellidosAndEmail(String nombres, String apellidos, String email);
   
}

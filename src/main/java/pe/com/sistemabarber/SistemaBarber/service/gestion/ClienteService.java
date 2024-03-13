
package pe.com.sistemabarber.SistemaBarber.service.gestion;


import java.util.Optional;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.ClienteDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.ClienteEntity;
import pe.com.sistemabarber.SistemaBarber.service.base.BaseService;

/**
 *
 * @author ACER
 */
public interface ClienteService extends BaseService<ClienteDTO>{
        Optional<ClienteEntity> findByNombresAndApellidosAndEmail(String nombres, String apellidos, String email);

    
}

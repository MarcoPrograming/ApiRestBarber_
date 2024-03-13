
package pe.com.sistemabarber.SistemaBarber.repository.gestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CitasEntity;

@Repository
public interface CitasRepository extends JpaRepository<CitasEntity, Long> {
}

package pe.com.sistemabarber.SistemaBarber.service.impl.gestion;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.models.gestion.TipoCitasEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.TipoCitasRepository;

@Service
public class TipoCitasServiceImpl {
        @Autowired
    private final TipoCitasRepository citasRepository;

        // Constructor con inyección de dependencias del repositorio
        public TipoCitasServiceImpl(TipoCitasRepository citasRepository) {
            this.citasRepository = citasRepository;
        }
    
    public void guardarTipoCita(TipoCitasEntity tipoCitas) {

        if (existeTipoCitasPorNombre(tipoCitas)) {
            throw new RuntimeException("Error: Tipo de Citas  duplicado");
        }

        tipoCitas.setFechaCreacion(LocalDateTime.now());
        tipoCitas.setFechaActualizacion(LocalDateTime.now());
        citasRepository.save(tipoCitas);
    }


    private boolean existeTipoCitasPorNombre(TipoCitasEntity tipoCitas) {
        Optional<TipoCitasEntity> TipoCitasExistente = citasRepository
                .findByNombre(
                        tipoCitas.getNombre().toLowerCase()
                );
        return TipoCitasExistente.isPresent();
    }


}

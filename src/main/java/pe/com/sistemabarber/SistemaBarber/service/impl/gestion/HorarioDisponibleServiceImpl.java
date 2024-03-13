package pe.com.sistemabarber.SistemaBarber.service.impl.gestion;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.models.gestion.HorarioDisponibleEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.HorarioDisponibleRepository;


@Service
public class HorarioDisponibleServiceImpl {
     @Autowired
 private final HorarioDisponibleRepository horariodis;
     
      public HorarioDisponibleServiceImpl(HorarioDisponibleRepository horarioRepository){
    this.horariodis = horarioRepository;
 }
      
      
          public void guardarHorario(HorarioDisponibleEntity horario) {
        // Verificar si el cliente ya existe por nombres, apellidos y email
        if (existeHorarioPorNombre(horario)) {
            throw new RuntimeException("Error: Nombre de la fecha del horario  duplicado");
        }

        // Lógica para guardar el cliente si no existe
        horario.setFecha_creacion(LocalDateTime.now());
        horariodis.save(horario);
    }
          
              private boolean existeHorarioPorNombre(HorarioDisponibleEntity horario) {
        Optional<HorarioDisponibleEntity> HorarioExistente = horariodis
                .findByNombre(
                        horario.getNombre()
                );
        return HorarioExistente.isPresent();
    }




     
     


}

package pe.com.sistemabarber.SistemaBarber.service.impl.gestion;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.models.gestion.HorarioEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.HorarioRepository;


@Service
public class HorarioServiceImpl {
 @Autowired
 private final HorarioRepository HorarioRepository;

 public HorarioServiceImpl(HorarioRepository horarioRepository){
    this.HorarioRepository = horarioRepository;
 }
 
    public void guardarHorario(HorarioEntity horario) {
        // Verificar si el cliente ya existe por nombres, apellidos y email
        if (existeHorarioPorNombre(horario)) {
            throw new RuntimeException("Error: Nombre de la fecha del horario  duplicado");
        }

        // Lógica para guardar el cliente si no existe
        horario.setFecha_creacion(LocalDateTime.now());
        horario.setFecha_actualizacion(LocalDateTime.now());
        HorarioRepository.save(horario);
    }


    private boolean existeHorarioPorNombre(HorarioEntity horario) {
        Optional<HorarioEntity> HorarioExistente = HorarioRepository
                .findByNombre(
                        horario.getNombre()
                );
        return HorarioExistente.isPresent();
    }



}

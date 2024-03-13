package pe.com.sistemabarber.SistemaBarber.controller.gestion;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;
import pe.com.sistemabarber.SistemaBarber.models.gestion.HorarioDisponibleEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.HorarioDisponibleRepository;
import pe.com.sistemabarber.SistemaBarber.service.impl.gestion.HorarioDisponibleServiceImpl;

/**
 *
 * @author ACER
 */

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class HorarioDisponibleController {
    
        @Autowired
    private HorarioDisponibleRepository horarioRepository;
    @Autowired
    private HorarioDisponibleServiceImpl horarioService;

        @GetMapping("/HorarioDispo")
public List<HorarioDisponibleEntity> listarTodosLosHorariosDisponibles() {
        return horarioRepository.findAll();
    }



    @PostMapping("/HorarioDispo")
public ResponseEntity<?> guardarHorarioDis(@RequestBody HorarioDisponibleEntity horario) {
    try {
        horarioService.guardarHorario(horario);

        return ResponseEntity.ok(horario);
    } catch (Exception e) {
        return new ResponseEntity<>("Error: El nombre del dia ya existe", HttpStatus.BAD_REQUEST);
    }


}


    //Busca HorarioEntity por id 
    @GetMapping("/HorarioDispo/{id}")
    public ResponseEntity<HorarioDisponibleEntity> obtenerHoraio (@PathVariable Long id){
        HorarioDisponibleEntity horario   = horarioRepository.findById(id)
        .orElseThrow(() -> new ResolutionException("No existe el Horario disponible con el ID: " + id));
        return ResponseEntity.ok(horario);
    }


            @PutMapping("/HorarioDispo/{id}")
        public ResponseEntity<HorarioDisponibleEntity> actualizarHorario (@PathVariable Long id,@RequestBody HorarioDisponibleEntity horario){
        HorarioDisponibleEntity horarios= horarioRepository.findById(id)
        .orElseThrow(() -> new ResolutionException("No existe el Horario disponible con el ID: " + id));
             horarios.setFecha(horario.getFecha());
        horarios.setNombre(horario.getNombre());
       horarios.setHora_inicio(horario.getHora_inicio());
       horarios.setHora_fin(horario.getHora_fin());
       HorarioDisponibleEntity HorarioActualizado= horarioRepository.save(horarios);
        return ResponseEntity.ok(HorarioActualizado);
    }
        
                //eliminar
    @DeleteMapping("/HorarioDispo/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarHoarioDis(@PathVariable Long id){
        HorarioDisponibleEntity horario= horarioRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFounException("No existe el cliente con el ID" + id));

        horarioRepository.delete(horario);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }





    
}

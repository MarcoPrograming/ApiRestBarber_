package pe.com.sistemabarber.SistemaBarber.controller.gestion;

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

import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.*;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;
import pe.com.sistemabarber.SistemaBarber.models.gestion.HorarioEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.HorarioRepository;
import pe.com.sistemabarber.SistemaBarber.service.impl.gestion.HorarioServiceImpl;
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")  //RESPONDE AL BACKEND Y FRONTEND
public class HorarioController {
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private HorarioServiceImpl horarioService;

        @GetMapping("/Horario")
public List<HorarioEntity> listarTodosLosHorarios() {
        return horarioRepository.findAll();
    }

    //GUARDA REGISTRO
    @PostMapping("/Horario")
public ResponseEntity<?> guardarHorario(@RequestBody HorarioEntity horario) {
    try {
        horarioService.guardarHorario(horario);

        return ResponseEntity.ok(horario);
    } catch (Exception e) {
        return new ResponseEntity<>("Error: El nombre del dia ya existe", HttpStatus.BAD_REQUEST);
    }


}

    //Busca HorarioEntity por id 
    @GetMapping("/Horario/{id}")
    public ResponseEntity<HorarioEntity> obtenerHoraio (@PathVariable Long id){
        HorarioEntity horario   = horarioRepository.findById(id)
        .orElseThrow(() -> new ResolutionException("No existe el Horario con el ID: " + id));
        return ResponseEntity.ok(horario);
    }

    
        @PutMapping("/Horario/{id}")
        public ResponseEntity<HorarioEntity> actualizarHorario (@PathVariable Long id,@RequestBody HorarioEntity horario){
        HorarioEntity horarios= horarioRepository.findById(id)
        .orElseThrow(() -> new ResolutionException("No existe el Horario  con el ID: " + id));
       horarios.setNombre(horario.getNombre());
       horarios.setHora_inicio(horario.getHora_inicio());
       horarios.setHora_fin(horario.getHora_fin());
       horarios.setFecha_actualizacion(LocalDateTime.now());
       HorarioEntity HorarioActualizado= horarioRepository.save(horarios);
        return ResponseEntity.ok(HorarioActualizado);
    }

        //eliminar
    @DeleteMapping("/Horario/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarHorario(@PathVariable Long id){
        HorarioEntity horario= horarioRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFounException("No existe el cliente con el ID" + id));

        horarioRepository.delete(horario);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }







}

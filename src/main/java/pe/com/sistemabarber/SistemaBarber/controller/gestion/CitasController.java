package pe.com.sistemabarber.SistemaBarber.controller.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.CitasDTO;
import pe.com.sistemabarber.SistemaBarber.service.gestion.CitasService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class CitasController {

    @Autowired
    private CitasService citasService;

    @GetMapping("/citas")
    public ResponseEntity<List<CitasDTO>> listarTodasLasCitas() {
        List<CitasDTO> citas = citasService.findAll();
        return ResponseEntity.ok(citas);
    }


    @GetMapping("/citas/{id}")
    public ResponseEntity<CitasDTO> obtenerCitaPorId(@PathVariable Long id) {
        CitasDTO cita = citasService.findById(id);
        if (cita != null) {
            return ResponseEntity.ok(cita);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/citas")
    public ResponseEntity<CitasDTO> guardarCita(@RequestBody CitasDTO citaDTO) {

        citaDTO.setFechaRegistro(LocalDateTime.now());

        if (citaDTO.getFechaCita() == null) {
            citaDTO.setFechaCita(LocalDateTime.now());
        }

        CitasDTO citaGuardada = citasService.guardar(citaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(citaGuardada);
    }

    @PutMapping("/citas/{id}")
    public ResponseEntity<CitasDTO> actualizarCita(@PathVariable Long id, @RequestBody CitasDTO citaDTO) {
        CitasDTO citaActualizada = citasService.actualizar(citaDTO, id);
        if (citaActualizada != null) {
            return ResponseEntity.ok(citaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //eliminar
    @DeleteMapping("/citas/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCita(@PathVariable Long id){
        CitasDTO citas= citasService.findById(id);
        citasService.delete(id);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

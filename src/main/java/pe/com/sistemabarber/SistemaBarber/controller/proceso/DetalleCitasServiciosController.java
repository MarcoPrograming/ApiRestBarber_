package pe.com.sistemabarber.SistemaBarber.controller.proceso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.sistemabarber.SistemaBarber.dto.proceso.CitasServiciosDTO;

import java.util.List;
import java.util.Optional;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;
import pe.com.sistemabarber.SistemaBarber.service.proceso.DetalleCitasServiciosService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleCitasServiciosController {

    @Autowired
    private DetalleCitasServiciosService citasServiciosService;

    @GetMapping("/citas-servicios")
    public List<CitasServiciosDTO> listarTodosLosCitasServicios() {
        return citasServiciosService.findAll();
    }

    @PostMapping("/citas-servicios")
    public ResponseEntity<CitasServiciosDTO> guardarCitasServicio(@RequestBody CitasServiciosDTO citasServiciosDTO) {
        try {
            return ResponseEntity.ok(citasServiciosService.guardar(citasServiciosDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/citas-servicios/{id}")
    public ResponseEntity<CitasServiciosDTO> obtenerCitasServicio(@PathVariable Long id) {
        CitasServiciosDTO citasServiciosDTO = citasServiciosService.findById(id);
        if (citasServiciosDTO != null) {
            return ResponseEntity.ok(citasServiciosDTO);
        } else {
            throw new ResourceNotFounException("Detalle de cita no encontrado con el ID: " + id);
        }
    }

    @PutMapping("/citas-servicios/{id}")
    public ResponseEntity<CitasServiciosDTO> actualizarCitasServicio(@PathVariable Long id, @RequestBody CitasServiciosDTO citasServiciosDTO) {
        return ResponseEntity.ok(citasServiciosService.actualizar(citasServiciosDTO, id));
    }

    @DeleteMapping("/citas-servicios/{id}")
    public ResponseEntity<?> eliminarCitasServicio(@PathVariable Long id) {
        Optional<CitasServiciosDTO> citasServiciosDTOOptional = Optional.ofNullable(citasServiciosService.findById(id));
        if (citasServiciosDTOOptional.isPresent()) {
            citasServiciosService.delete(id);
            return ResponseEntity.ok("Detalle de cita eliminado exitosamente");
        } else {
            throw new ResourceNotFounException("Detalle de cita no encontrado con el ID: " + id);
        }
    }
}

package pe.com.sistemabarber.SistemaBarber.controller.gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.ServicioDTO;
import pe.com.sistemabarber.SistemaBarber.service.impl.gestion.ServicioServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioController {

    @Autowired
    private ServicioServiceImpl servicioService;

    @GetMapping("/servicios")
    public List<ServicioDTO> listarTodosLosServicios() {
        return servicioService.findAll();
    }

    @PostMapping("/servicios")
    public ResponseEntity<?> guardarServicio(@RequestBody ServicioDTO servicioDTO) {
        try {
            servicioDTO.setFechaCreacion(LocalDateTime.now());
            servicioDTO.setFechaActualizacion(LocalDateTime.now());
            return ResponseEntity.ok(servicioService.guardar(servicioDTO));
        } catch (Exception e) {
            return new ResponseEntity<>("Error: Servicio duplicado", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/servicios/{id}")
    public ResponseEntity<ServicioDTO> obtenerServicio(@PathVariable Long id) {
        ServicioDTO servicioDTO = servicioService.findById(id);
        if (servicioDTO != null) {
            return ResponseEntity.ok(servicioDTO);
        } else {
            throw new ResourceNotFounException("Servicio no encontrado con el ID: " + id);
        }
    }

    @PutMapping("/servicios/{id}")
    public ResponseEntity<ServicioDTO> actualizarServicio(@PathVariable Long id, @RequestBody ServicioDTO servicioDTO) {
        servicioDTO.setFechaActualizacion(LocalDateTime.now());
        return ResponseEntity.ok(servicioService.actualizar(servicioDTO, id));
    }

    @DeleteMapping("/servicios/{id}")
    public ResponseEntity<?> eliminarServicio(@PathVariable Long id) {
        Optional<ServicioDTO> servicioDTOOptional = Optional.ofNullable(servicioService.findById(id));
        if (servicioDTOOptional.isPresent()) {
            servicioService.delete(id);
            return ResponseEntity.ok("Servicio eliminado exitosamente");
        } else {
            throw new ResourceNotFounException("Servicio no encontrado con el ID: " + id);
        }
    }
}

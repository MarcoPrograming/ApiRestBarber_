package pe.com.sistemabarber.SistemaBarber.controller.proceso.procesoInventario;

import java.util.List;
import java.util.Optional;
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
import pe.com.sistemabarber.SistemaBarber.dto.proceso.procesoInventario.DetalleProductoCategoriaDTO;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;
import pe.com.sistemabarber.SistemaBarber.service.proceso.procesoInventario.DetalleProductoCategoriaService;

/**
 *
 * @author ACER
 */

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleProductoCategoriaRestController {
            @Autowired
    private DetalleProductoCategoriaService detalle;

    @GetMapping("/detalle_ProducCat")
    public List<DetalleProductoCategoriaDTO> listar() {
        return detalle.findAll();
    }

    @PostMapping("/detalle_ProducCat")
    public ResponseEntity<DetalleProductoCategoriaDTO> guardar(@RequestBody DetalleProductoCategoriaDTO detalledto) {
        try {
            return ResponseEntity.ok(detalle.guardar(detalledto));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/detalle_ProducCat/{id}")
    public ResponseEntity<DetalleProductoCategoriaDTO> obtener(@PathVariable Long id) {
        DetalleProductoCategoriaDTO detalleDto = detalle.findById(id);
        if (detalleDto != null) {
            return ResponseEntity.ok(detalleDto);
        } else {
            throw new ResourceNotFounException("Orden no encontrado con el ID: " + id);
        }
    }

    @PutMapping("/detalle_ProducCat/{id}")
    public ResponseEntity<DetalleProductoCategoriaDTO> actualizar(@PathVariable Long id, @RequestBody DetalleProductoCategoriaDTO detalleDto) {
        return ResponseEntity.ok(detalle.actualizar(detalleDto, id));
    }

    @DeleteMapping("/detalle_ProducCat/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<DetalleProductoCategoriaDTO> detalleO = Optional.ofNullable(detalle.findById(id));
        if (detalleO.isPresent()) {
            detalle.delete(id);
            return ResponseEntity.ok("Orden eliminado exitosamente");
        } else {
            throw new ResourceNotFounException("Orden no encontrado con el ID: " + id);
        }
    }


}

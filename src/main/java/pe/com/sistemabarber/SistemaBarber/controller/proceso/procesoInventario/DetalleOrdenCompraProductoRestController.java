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
import pe.com.sistemabarber.SistemaBarber.dto.proceso.procesoInventario.DetalleOrdenCompraProductoDTO;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;
import pe.com.sistemabarber.SistemaBarber.service.proceso.procesoInventario.DetalleOrdenCompraProductoService;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleOrdenCompraProductoRestController {
        @Autowired
    private DetalleOrdenCompraProductoService detalle;

    @GetMapping("/detalle_Orden")
    public List<DetalleOrdenCompraProductoDTO> listar() {
        return detalle.findAll();
    }

    @PostMapping("/detalle_Orden")
    public ResponseEntity<DetalleOrdenCompraProductoDTO> guardar(@RequestBody DetalleOrdenCompraProductoDTO detalledto) {
        try {
            return ResponseEntity.ok(detalle.guardar(detalledto));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/detalle_Orden/{id}")
    public ResponseEntity<DetalleOrdenCompraProductoDTO> obtener(@PathVariable Long id) {
        DetalleOrdenCompraProductoDTO citasServiciosDTO = detalle.findById(id);
        if (citasServiciosDTO != null) {
            return ResponseEntity.ok(citasServiciosDTO);
        } else {
            throw new ResourceNotFounException("Orden no encontrado con el ID: " + id);
        }
    }

    @PutMapping("/detalle_Orden/{id}")
    public ResponseEntity<DetalleOrdenCompraProductoDTO> actualizar(@PathVariable Long id, @RequestBody DetalleOrdenCompraProductoDTO ordenDto) {
        return ResponseEntity.ok(detalle.actualizar(ordenDto, id));
    }

    @DeleteMapping("/detalle_Orden/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<DetalleOrdenCompraProductoDTO> citasServiciosDTOOptional = Optional.ofNullable(detalle.findById(id));
        if (citasServiciosDTOOptional.isPresent()) {
            detalle.delete(id);
            return ResponseEntity.ok("Orden eliminado exitosamente");
        } else {
            throw new ResourceNotFounException("Orden no encontrado con el ID: " + id);
        }
    }
}


package pe.com.sistemabarber.SistemaBarber.controller.gestion.gestionInventario;

import java.time.LocalDateTime;
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
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.ProveedorDTO;
import pe.com.sistemabarber.SistemaBarber.service.gestion.gestionInventario.ProveedorService;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorRestController {
                  @Autowired
    private ProveedorService service;

      @GetMapping("/proveedor")
    public ResponseEntity<List<ProveedorDTO>> lista() {
        List<ProveedorDTO> categoria = service.findAll();
        return ResponseEntity.ok(categoria);
    }


    @GetMapping("/proveedor/{id}")
    public ResponseEntity<ProveedorDTO> obtenerPorId(@PathVariable Long id) {
        ProveedorDTO producto = service.findById(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/proveedor")
    public ResponseEntity<ProveedorDTO> guardar(@RequestBody ProveedorDTO producto) {

        producto.setFecha_creacion(LocalDateTime.now());

        ProveedorDTO cp = service.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cp);
    }

    @PutMapping("/proveedor/{id}")
    public ResponseEntity<ProveedorDTO> actualizar(@PathVariable Long id, @RequestBody ProveedorDTO producto) {
        ProveedorDTO productos = service.actualizar(producto, id);
        if (productos != null) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //eliminar
    @DeleteMapping("/proveedor/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Long id){
        service.delete(id);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

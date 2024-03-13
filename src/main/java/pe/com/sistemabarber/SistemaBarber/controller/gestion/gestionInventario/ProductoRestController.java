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
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.ProductoDTO;
import pe.com.sistemabarber.SistemaBarber.service.gestion.gestionInventario.ProductoService;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoRestController {
                @Autowired
    private ProductoService service;


    @GetMapping("/producto")
    public ResponseEntity<List<ProductoDTO>> lista() {
        List<ProductoDTO> categoria = service.findAll();
        return ResponseEntity.ok(categoria);
    }


    @GetMapping("/producto/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable Long id) {
        ProductoDTO producto = service.findById(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/producto")
    public ResponseEntity<ProductoDTO> guardar(@RequestBody ProductoDTO producto) {

        producto.setFecha_creacion(LocalDateTime.now());

        ProductoDTO cp = service.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cp);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable Long id, @RequestBody ProductoDTO producto) {
        ProductoDTO productos = service.actualizar(producto, id);
        if (productos != null) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //eliminar
    @DeleteMapping("/producto/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Long id){
        service.delete(id);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}


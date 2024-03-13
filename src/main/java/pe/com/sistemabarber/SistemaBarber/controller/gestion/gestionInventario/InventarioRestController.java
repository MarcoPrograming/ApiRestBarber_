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
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.InventarioDTO;
import pe.com.sistemabarber.SistemaBarber.service.gestion.gestionInventario.InventarioService;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class InventarioRestController {
      @Autowired
    private InventarioService service;
      
        @GetMapping("/inventario")
    public ResponseEntity<List<InventarioDTO>> listar() {
        List<InventarioDTO> inventario = service.findAll();
        return ResponseEntity.ok(inventario);
    }

    
     @GetMapping("/inventario/{id}")
    public ResponseEntity<InventarioDTO> obtenerPorId(@PathVariable Long id) {
        InventarioDTO inventario = service.findById(id);
        if (inventario != null) {
            return ResponseEntity.ok(inventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/inventario")
    public ResponseEntity<InventarioDTO> guardar(@RequestBody InventarioDTO inventario) {

        inventario.setFecha_creacion(LocalDateTime.now());

        InventarioDTO cp = service.guardar(inventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(cp);
    }

    @PutMapping("/inventario/{id}")
    public ResponseEntity<InventarioDTO> actualizar(@PathVariable Long id, @RequestBody InventarioDTO catego) {
        InventarioDTO categorias = service.actualizar(catego, id);
        if (categorias != null) {
            return ResponseEntity.ok(categorias);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //eliminar
    @DeleteMapping("/inventario/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Long id){
        service.delete(id);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

      
      
      
     
}

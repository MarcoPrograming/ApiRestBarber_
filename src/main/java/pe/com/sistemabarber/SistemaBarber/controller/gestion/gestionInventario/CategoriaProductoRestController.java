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
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.CategoriaProductoDTO;
import pe.com.sistemabarber.SistemaBarber.service.gestion.gestionInventario.CategoriaProductoService;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaProductoRestController {
            @Autowired
    private CategoriaProductoService service;

    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaProductoDTO>> lista() {
        List<CategoriaProductoDTO> categoria = service.findAll();
        return ResponseEntity.ok(categoria);
    }


    @GetMapping("/categoria/{id}")
    public ResponseEntity<CategoriaProductoDTO> obtenerPorId(@PathVariable Long id) {
        CategoriaProductoDTO categoria = service.findById(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/categoria")
    public ResponseEntity<CategoriaProductoDTO> guardar(@RequestBody CategoriaProductoDTO categoria) {

        categoria.setFecha_creacion(LocalDateTime.now());

        CategoriaProductoDTO cp = service.guardar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(cp);
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity<CategoriaProductoDTO> actualizar(@PathVariable Long id, @RequestBody CategoriaProductoDTO catego) {
        CategoriaProductoDTO categorias = service.actualizar(catego, id);
        if (categorias != null) {
            return ResponseEntity.ok(categorias);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //eliminar
    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Long id){
        service.delete(id);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

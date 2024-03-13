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
import pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario.OrdenCompraDTO;
import pe.com.sistemabarber.SistemaBarber.service.gestion.gestionInventario.OrdenCompraService;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdenCompraRestController {
                @Autowired
    private OrdenCompraService service;

    @GetMapping("/ordencompra")
    public ResponseEntity<List<OrdenCompraDTO>> lista() {
        List<OrdenCompraDTO> compra = service.findAll();
        return ResponseEntity.ok(compra);
    }


    @GetMapping("/ordencompra/{id}")
    public ResponseEntity<OrdenCompraDTO> obtenerPorId(@PathVariable Long id) {
        OrdenCompraDTO compra = service.findById(id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/ordencompra")
    public ResponseEntity<OrdenCompraDTO> guardar(@RequestBody OrdenCompraDTO compra) {

        compra.setFecha_creacion(LocalDateTime.now());

        OrdenCompraDTO cp = service.guardar(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(cp);
    }

    @PutMapping("/ordencompra/{id}")
    public ResponseEntity<OrdenCompraDTO> actualizar(@PathVariable Long id, @RequestBody OrdenCompraDTO compra) {
        OrdenCompraDTO compras = service.actualizar(compra, id);
        if (compras != null) {
            return ResponseEntity.ok(compras);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //eliminar
    @DeleteMapping("/ordencompra/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Long id){
        service.delete(id);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}


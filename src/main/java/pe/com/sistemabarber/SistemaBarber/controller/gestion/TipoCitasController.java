package pe.com.sistemabarber.SistemaBarber.controller.gestion;

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


import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.*;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;
import pe.com.sistemabarber.SistemaBarber.models.gestion.TipoCitasEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.TipoCitasRepository;
import pe.com.sistemabarber.SistemaBarber.service.impl.gestion.TipoCitasServiceImpl;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200") // RESPONDE AL BACKEND Y FRONTEND

public class TipoCitasController {

    @Autowired
    private TipoCitasRepository tipoCitasRepository;

    @Autowired
    private TipoCitasServiceImpl tipCitasService;

    @GetMapping("/tipoCitas")
    public List<TipoCitasEntity> listarTodosLosTiposCitas() {
        return tipoCitasRepository.findAll();
    }

    // GUARDA REGISTRO
    @PostMapping("/tipoCitas")
    public ResponseEntity<?> guardarCliente(@RequestBody TipoCitasEntity tipoCitas) {
        try {
            tipCitasService.guardarTipoCita(tipoCitas);

            return ResponseEntity.ok(tipoCitas);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: Tipo cita ya existe", HttpStatus.BAD_REQUEST);
        }
    }

       
    //Busca Tipo Cita por id 
    @GetMapping("/tipoCitas/{id}")
    public ResponseEntity<TipoCitasEntity> obtenerTipoCita (@PathVariable Long id){
        TipoCitasEntity tipoCitas   = tipoCitasRepository.findById(id)
        .orElseThrow(() -> new ResolutionException("No existe el Tipo de cita con el ID: " + id));
        return ResponseEntity.ok(tipoCitas);
    }
    //Actualizar Tipo Citas

        @PutMapping("/tipoCitas/{id}")
        public ResponseEntity<TipoCitasEntity> actualizarTipoCita (@PathVariable Long id,@RequestBody TipoCitasEntity tipoCitas){
        TipoCitasEntity tipoCita= tipoCitasRepository.findById(id)
        .orElseThrow(() -> new ResolutionException("No existe el Tipo de cita con el ID: " + id));
       tipoCita.setNombre(tipoCitas.getNombre());
       tipoCita.setDescripcion(tipoCitas.getDescripcion());
       tipoCita.setEstado(tipoCitas.getEstado());
       tipoCitas.setFechaActualizacion(LocalDateTime.now());
       TipoCitasEntity TipoCitasActualizado= tipoCitasRepository.save(tipoCita);
        return ResponseEntity.ok(TipoCitasActualizado);
    }

        //eliminar
    @DeleteMapping("/tipoCitas/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarTipoCita(@PathVariable Long id){
        TipoCitasEntity tipoCitas= tipoCitasRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFounException("No existe el Tipo de Cita con el ID" + id));
        tipoCitasRepository.delete(tipoCitas);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }






}

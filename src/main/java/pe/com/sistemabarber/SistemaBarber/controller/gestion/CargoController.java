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
import pe.com.sistemabarber.SistemaBarber.dto.gestion.CargoDTO;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CargoEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.CargoRepository;
import pe.com.sistemabarber.SistemaBarber.service.impl.gestion.CargoServiceImpl;
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200") 

public class CargoController {
    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private CargoServiceImpl cargoService;

        @GetMapping("/Cargo")
    public List<CargoEntity> listarTodosLosCargos() {
        return  cargoRepository.findAll();
    }

    
    // GUARDA REGISTRO
    @PostMapping("/Cargo")
    public ResponseEntity<?> guardarCargo(@RequestBody CargoDTO cargo) {
        try {
            cargoService.guardar(cargo);

            return ResponseEntity.ok(cargo);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: Cargo ya existe", HttpStatus.BAD_REQUEST);
        }
    }
    
        //Busca Crago por id 
    @GetMapping("/Cargo/{id}")
    public ResponseEntity<CargoEntity> obtenerCargo (@PathVariable Long id){
        CargoEntity cargo   = cargoRepository.findById(id)
        .orElseThrow(() -> new ResolutionException("No existe el Cargo con el ID: " + id));
        return ResponseEntity.ok(cargo);
    }

        //Actualizar CargoEntity

        @PutMapping("/Cargo/{id}")
        public ResponseEntity<CargoEntity> actualizarCargo (@PathVariable Long id,@RequestBody CargoEntity cargo){
        CargoEntity cargos= cargoRepository.findById(id)
        .orElseThrow(() -> new ResolutionException("No existe el Cargo con el ID: " + id));
       cargos.setNombre(cargo.getNombre());
       cargos.setDescripcion(cargo.getDescripcion());
       cargos.setEstado(cargo.getEstado());
       cargos.setFechaCreacion(LocalDateTime.now());
       CargoEntity CargoActualizado= cargoRepository.save(cargos);
        return ResponseEntity.ok(CargoActualizado);
    }

            //eliminar
    @DeleteMapping("/Cargo/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCargo(@PathVariable Long id){
        CargoEntity cargo= cargoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFounException("No existe el Cargo con el ID" + id));
        cargoRepository.delete(cargo);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }












}

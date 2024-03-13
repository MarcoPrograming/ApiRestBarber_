package pe.com.sistemabarber.SistemaBarber.controller.gestion;

import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.EmpleadoDTO;
import pe.com.sistemabarber.SistemaBarber.service.gestion.EmpleadoService;

import java.util.List;
import java.util.Map;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;
import pe.com.sistemabarber.SistemaBarber.models.gestion.EmpleadoEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.EmpleadoRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository repository;
    @Autowired
    private EmpleadoService empleadoService;

        @GetMapping("/empleados")
public List<Map<String, Object>> listarTodosLosEmpleados() {
    List<EmpleadoDTO> empleados = empleadoService.findAll();
    List<Map<String, Object>> empleadosList = new ArrayList<>();

    for (EmpleadoDTO empleado : empleados) {
        Map<String, Object> empleadoMap = new HashMap<>();
                empleadoMap.put("id_empleado", empleado.getCodigo());

        empleadoMap.put("cargo", empleado.getCargo().getNombre());
        empleadoMap.put("horario", empleado.getHorario().getNombre() + " " + empleado.getHorario().getHora_inicio());
        empleadoMap.put("nombre", empleado.getNombre());
        empleadoMap.put("apellidos", empleado.getApellidos());
        empleadoMap.put("tipoDoc", empleado.getTipoDoc());
        empleadoMap.put("numDoc", empleado.getNumDoc());
        empleadoMap.put("edad", empleado.getEdad());
        empleadoMap.put("correo", empleado.getCorreo());
        empleadoMap.put("telefono", empleado.getTelefono());
        empleadoMap.put("direccion", empleado.getDireccion());
        empleadoMap.put("estado", empleado.getEstado());
        empleadoMap.put("fecha_creacion", empleado.getFecha_creacion());
        empleadoMap.put("fecha_actualizacion", empleado.getFecha_actualizacion());

        empleadosList.add(empleadoMap);
    }

    return empleadosList;
}



    @GetMapping("/empleados/{id}")
    public List<Map<String, Object>> obtenerEmpleadoPorId(@PathVariable Long id) {
        EmpleadoDTO empleado = empleadoService.findById(id);
            List<Map<String, Object>> empleadosList = new ArrayList<>();
        if (empleado != null) {
              
        Map<String, Object> empleadoMap = new HashMap<>();
        empleadoMap.put("cargo", empleado.getCargo().getNombre());
        empleadoMap.put("horario", empleado.getHorario().getHora_inicio());
        empleadoMap.put("nombre", empleado.getNombre());
        empleadoMap.put("apellidos", empleado.getApellidos());
        empleadoMap.put("tipoDoc", empleado.getTipoDoc());
         empleadoMap.put("numDoc", empleado.getNumDoc());
        empleadoMap.put("edad", empleado.getEdad());
        empleadoMap.put("correo", empleado.getCorreo());
        empleadoMap.put("telefono", empleado.getTelefono());
        empleadoMap.put("direccion", empleado.getDireccion());
        empleadoMap.put("estado", empleado.getEstado());
        empleadoMap.put("fecha_creacion", empleado.getFecha_creacion());
        empleadoMap.put("fecha_actualizacion", empleado.getFecha_actualizacion());

        empleadosList.add(empleadoMap);
        return empleadosList;
        } else {
          return (List<Map<String, Object>>) ResponseEntity.notFound().build();
        }
    }
    

    
  /*  @GetMapping("/empleados/{id}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleadoPorId(@PathVariable Long id) {
        EmpleadoDTO empleado = empleadoService.findById(id);
        if (empleado != null) {
            return ResponseEntity.ok(empleado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
    
    
    
    //GUARDA REGISTRO
@PostMapping("/empleados")
public ResponseEntity<?> guardar(@RequestBody EmpleadoDTO emp) {
    try {
        empleadoService.guardar(emp);

        return ResponseEntity.ok(emp);
    } catch (Exception e) {
        return new ResponseEntity<>("Error:Datos incorrectos", HttpStatus.BAD_REQUEST);
 }
}

//
//    @PostMapping("/empleados")
//    public ResponseEntity<EmpleadoDTO> guardarEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
//        EmpleadoDTO empleadoGuardado = empleadoService.guardar(empleadoDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoGuardado);
//    }

@PutMapping("/empleados/{id}")
public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@PathVariable Long id, @RequestBody EmpleadoDTO empleado) {
    EmpleadoDTO empleados= empleadoService.findById(id);
    if (empleados == null) {
        return ResponseEntity.notFound().build();
    }
    empleado.setFecha_actualizacion(LocalDateTime.now());
    EmpleadoDTO empleadoActualizado = empleadoService.guardar(empleado);
    return ResponseEntity.ok(empleadoActualizado);
}


//    @DeleteMapping("/empleados/{id}")
//    public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable Long id){
//        empleadoService.delete(id);
//        Map<String,Boolean>respuesta = new HashMap<>();
//        respuesta.put("Eliminar", Boolean.TRUE);
//        return ResponseEntity.ok(respuesta);
//    }

        @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminar(@PathVariable Long id){
        EmpleadoEntity em= repository.findById(id)
        .orElseThrow(() -> new ResourceNotFounException("No existe el cliente con el ID" + id));

        repository.delete(em);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    
    


}

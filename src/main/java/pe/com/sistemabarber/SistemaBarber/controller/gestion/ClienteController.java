package pe.com.sistemabarber.SistemaBarber.controller.gestion;

import java.io.IOException;
import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
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


import org.springframework.http.HttpStatus;

import pe.com.sistemabarber.SistemaBarber.dto.gestion.ClienteDTO;
import pe.com.sistemabarber.SistemaBarber.excepciones.ResourceNotFounException;
import pe.com.sistemabarber.SistemaBarber.models.gestion.ClienteEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.ClienteRepository;
import pe.com.sistemabarber.SistemaBarber.service.impl.gestion.ClienteServiceImpl;

//Para Crear la aplicacion hemos utilizado web service atraves de Rest 
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")  //RESPONDE AL BACKEND Y FRONTEND
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;

            @Autowired
    private ClienteServiceImpl clienteService;


    @GetMapping("/clientes")
public List<ClienteDTO> listarTodosLosClientes() {
        return clienteService.findAll();
    }
        // Supongamos que clienteRepository es tu repositorio JPA para la entidad Cliente


    //GUARDA REGISTRO
    @PostMapping("/clientes")
public ResponseEntity<?> guardarCliente(@RequestBody ClienteDTO cliente) {
    try {
        clienteService.guardar(cliente);
    
        return ResponseEntity.ok(cliente);
    } catch (Exception e) {
        return new ResponseEntity<>("Error: Cliente duplicado", HttpStatus.BAD_REQUEST);
    }
}
   
    //Busca ClienteEntity por id 
    //Busca cliente por id 
    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClienteEntity> obtenerCliente (@PathVariable Long id){
        ClienteEntity Cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new ResolutionException("No existe el cliente con el ID: " + id));
        return ResponseEntity.ok(Cliente);
    }


   
    @PutMapping("/clientes/{id}")
        public ResponseEntity<ClienteEntity> actualizarCliente (@PathVariable Long id,@RequestBody ClienteEntity dCliente){
        ClienteEntity Cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new ResolutionException("No existe el cliente con el ID: " + id));
       Cliente.setNombres(dCliente.getNombres());
       Cliente.setApellidos(dCliente.getApellidos());
       Cliente.setEdad(dCliente.getEdad());
       Cliente.setEmail(dCliente.getEmail());
       Cliente.setTelefono(dCliente.getTelefono());
       Cliente.setDireccion(dCliente.getDireccion());
       Cliente.setEstado(dCliente.getEstado());
       Cliente.setFecha_actualizacion(LocalDateTime.now());
       ClienteEntity clienteActualizado= clienteRepository.save(Cliente);
        return ResponseEntity.ok(clienteActualizado);
    }


    //eliminar
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable Long id){
        ClienteEntity Cliente= clienteRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFounException("No existe el cliente con el ID" + id));

        clienteRepository.delete(Cliente);
        Map<String,Boolean>respuesta = new HashMap<>();
        respuesta.put("Eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


//    @GetMapping("/clientes/descargar-pdf/{id}")
//public void descargarPDF(@PathVariable Long id, HttpServletResponse response) throws IOException {
//    // Lógica para obtener el PDF con el ID proporcionado
//    byte[] pdfBytes = clienteService.generarPDF(id);
//
//    response.setContentType("application/pdf");
//    response.setHeader("Content-Disposition", "inline; filename=detalle.pdf");
//    response.setContentLength(pdfBytes.length);
//
//    ServletOutputStream outputStream = response.getOutputStream();
//    outputStream.write(pdfBytes);
//    outputStream.close();
//}


}

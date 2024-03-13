package pe.com.sistemabarber.SistemaBarber.service.impl.gestion;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.ClienteDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.ClienteEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.ClienteRepository;
import pe.com.sistemabarber.SistemaBarber.service.gestion.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<ClienteEntity> findByNombresAndApellidosAndEmail(String nombres, String apellidos, String email) {
        return clienteRepository.findByNombresAndApellidosAndEmail(nombres, apellidos, email);
    }

    @Override
    public ClienteDTO findById(Long id) {
                ClienteEntity lista = clienteRepository.findById(id).get();
        return mapper.map(lista, ClienteDTO.class);

    }

    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteEntity> lista = clienteRepository.findAll();
        return lista.stream().map(c -> mapper.map(c, ClienteDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO guardar(ClienteDTO t) {
        ClienteEntity cliente = mapper.map(t, ClienteEntity.class);

        // Verificar si el ClienteEntity ya existe por nombres, apellidos y email
        if (existeClientePorNombresApellidosEmail(cliente)) {
            throw new RuntimeException("Error: Cliente duplicado");
        }

        // Lógica para guardar el ClienteEntity si no existe
        cliente.setFecha_creacion(LocalDateTime.now());
        cliente.setFecha_actualizacion(LocalDateTime.now());
        return mapper.map(clienteRepository.save(cliente), ClienteDTO.class);
    }

    @Override
    public ClienteDTO actualizar(ClienteDTO t, Long id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);

        // Verificar si el cliente existe antes de actualizarlo
        if (cliente.isPresent()) {
            mapper.map(t, cliente.get());
            return mapper.map(clienteRepository.save(cliente.get()), ClienteDTO.class);
        } else {
            throw new RuntimeException("Error: Cliente no encontrado");
        }
    }

    @Override
    public ClienteDTO delete(Long id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);

        // Verificar si el cliente existe antes de eliminarlo
        if (cliente.isPresent()) {
            cliente.get().setEstado("I");
            return mapper.map(clienteRepository.save(cliente.get()), ClienteDTO.class);
        } else {
            throw new RuntimeException("Error: Cliente no encontrado");
        }
    }

    private boolean existeClientePorNombresApellidosEmail(ClienteEntity cliente) {
        return clienteRepository.findByNombresAndApellidosAndEmail(cliente.getNombres(), cliente.getApellidos(), cliente.getEmail()).isPresent();
    }
}
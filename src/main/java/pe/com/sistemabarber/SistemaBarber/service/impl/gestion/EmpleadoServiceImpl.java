package pe.com.sistemabarber.SistemaBarber.service.impl.gestion;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.EmpleadoDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.EmpleadoEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.EmpleadoRepository;
import pe.com.sistemabarber.SistemaBarber.service.gestion.EmpleadoService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CargoEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.HorarioEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.CargoRepository;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.HorarioRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private HorarioRepository  horarioRepository;
    @Autowired
    private CargoRepository  cargoRepository;
    @Override
    public List<EmpleadoDTO> findAll() {
        List<EmpleadoEntity> empleados = empleadoRepository.findAll();
        return empleados.stream()
                .map(empleado -> mapper.map(empleado, EmpleadoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO guardar(EmpleadoDTO empleadoDTO) {
            EmpleadoEntity empleado = mapper.map(empleadoDTO, EmpleadoEntity.class);

        
        empleado.setFecha_creacion(LocalDateTime.now());
        empleado.setFecha_actualizacion(LocalDateTime.now());
        return mapper.map(empleadoRepository.save(empleado), EmpleadoDTO.class);
    }
    
//    public EmpleadoDTO guardar(EmpleadoDTO empleadoDTO) {
//        Optional<HorarioEntity> horarioOptional = horarioRepository.findById(empleadoDTO.getHorario().getId_horario());
//        Optional<CargoEntity> cargoOptional = cargoRepository.findById(empleadoDTO.getCargo().getId_cargo());
//
//        if (horarioOptional.isPresent() && cargoOptional.isPresent()) {
//            HorarioEntity horario = horarioOptional.get();
//            CargoEntity cargo = cargoOptional.get();
//
//            EmpleadoEntity empleado = new EmpleadoEntity();
//            empleado.setNombre(empleadoDTO.getNombre());
//            empleado.setApellidos(empleadoDTO.getApellidos());
//            empleado.setTipoDoc(empleadoDTO.getTipoDoc());
//            empleado.setNumDoc(empleadoDTO.getNumDoc());
//            empleado.setEdad(empleadoDTO.getEdad());
//            empleado.setCorreo(empleadoDTO.getCorreo());
//            empleado.setTelefono(empleadoDTO.getTelefono());
//                        empleado.setDireccion(empleadoDTO.getDireccion());
//                        empleado.setEstado(empleadoDTO.getEstado());
//            empleado.setHorario(horario);
//            empleado.setCargo(cargo);
//                    // Lógica para guardar el ClienteEntity si no existe
//        empleado.setFecha_creacion(LocalDateTime.now());
//        empleado.setFecha_actualizacion(LocalDateTime.now());
//
//
//            EmpleadoEntity empleadoGuardado = empleadoRepository.save(empleado);
//
//            EmpleadoDTO empleadoDTOGuardado = new EmpleadoDTO();
//            empleadoDTOGuardado.setCodigo(empleadoGuardado.getCodigo());
//            empleadoDTOGuardado.setNombre(empleadoGuardado.getNombre());
//            empleadoDTOGuardado.setApellidos(empleadoGuardado.getApellidos());
//                        empleadoDTOGuardado.setTipoDoc(empleadoGuardado.getTipoDoc());
//                                    empleadoDTOGuardado.setNumDoc(empleadoGuardado.getNumDoc());
//                                    empleadoDTOGuardado.setEdad(empleadoGuardado.getEdad());
//
//
//            empleadoDTOGuardado.setCorreo(empleadoGuardado.getCorreo());
//            empleadoDTOGuardado.setTelefono(empleadoGuardado.getTelefono());
//                        empleadoDTOGuardado.setDireccion(empleadoGuardado.getDireccion());
//
//            empleadoDTOGuardado.setHorario(horario);
//            empleadoDTOGuardado.setCargo(cargo);
//            empleadoDTOGuardado.setEstado(empleadoDTOGuardado.getEstado());
//                    // Lógica para guardar el ClienteEntity si no existe
//        empleadoDTOGuardado.setFecha_creacion(LocalDateTime.now());
//        empleadoDTOGuardado.setFecha_actualizacion(LocalDateTime.now());
//
//
//            return empleadoDTOGuardado;
//        } else {
//            throw new EntityNotFoundException("Horario o Cargo no encontrado con el id proporcionado.");
//        }
//    }

    @Override
    public EmpleadoDTO actualizar(EmpleadoDTO empleadoDTO, Long id) {
        Optional<EmpleadoEntity> empleadoOptional = empleadoRepository.findById(id);
        if (empleadoOptional.isPresent()) {
            EmpleadoEntity empleado = empleadoOptional.get();
            mapper.map(empleadoDTO, empleado);
            empleado.setFecha_actualizacion(LocalDateTime.now());
            return mapper.map(empleadoRepository.save(empleado), EmpleadoDTO.class);
        } else {
            throw new RuntimeException("Empleado no encontrado");
        }
    }

    @Override
    public EmpleadoDTO delete(Long id) {
        Optional<EmpleadoEntity> empleadoOptional = empleadoRepository.findById(id);
        if (empleadoOptional.isPresent()) {
            EmpleadoEntity empleado = empleadoOptional.get();
            empleado.setEstado("I");
            empleado.setFecha_actualizacion(LocalDateTime.now());
            return mapper.map(empleadoRepository.save(empleado), EmpleadoDTO.class);
        } else {
            throw new RuntimeException("Empleado no encontrado");
        }
    }

    @Override
    public EmpleadoDTO findById(Long id) {
        Optional<EmpleadoEntity> empleadoOptional = empleadoRepository.findById(id);
        if (empleadoOptional.isPresent()) {
            EmpleadoEntity empleadoEntity = empleadoOptional.get();
            return mapper.map(empleadoEntity, EmpleadoDTO.class);
        } else {
 
            return null;  
        }
    }

}

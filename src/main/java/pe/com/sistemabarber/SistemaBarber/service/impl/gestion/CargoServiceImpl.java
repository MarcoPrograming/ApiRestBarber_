package pe.com.sistemabarber.SistemaBarber.service.impl.gestion;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import pe.com.sistemabarber.SistemaBarber.dto.gestion.CargoDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CargoEntity;
import pe.com.sistemabarber.SistemaBarber.repository.gestion.CargoRepository;
import pe.com.sistemabarber.SistemaBarber.service.gestion.CargoService;

@Service
public class CargoServiceImpl implements CargoService {
    
   
    @Autowired
    private final CargoRepository repositorio;

      @Autowired 
    private ModelMapper mapper;
      
    public CargoServiceImpl(CargoRepository cargoRepository){
        this.repositorio= cargoRepository;
    }
        


   
    @Override
    public CargoDTO guardar(CargoDTO cargodto) {
        CargoEntity cargo = mapper.map(cargodto, CargoEntity.class);
        cargo.setFechaCreacion(LocalDateTime.now());
        cargo.setFechaActualizacion(LocalDateTime.now());
        return mapper.map(repositorio.save(cargo), CargoDTO.class);
    }
    
    
        private boolean existeCargoPorNombre(CargoDTO cargo) {
        Optional<CargoEntity> CargoExistente = repositorio
                .findByNombre(
                        cargo.getNombre().toLowerCase()
                );
        return CargoExistente.isPresent();
    }



    @Override
    public List<CargoDTO> findAll() {
               List<CargoEntity> lista = repositorio.findAll();
        return lista.stream().
                map(c -> mapper.map(c, CargoDTO.class))
                .collect(Collectors.toList());
    }
    
    

    @Override
    public CargoDTO findById(Long id) {
              CargoEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, 
                CargoDTO.class);

    }

    @Override
    public CargoDTO actualizar(CargoDTO t, Long id) {
             CargoEntity cargo = repositorio.findById(id).get();
        mapper.map(t, cargo);
        return mapper.map(repositorio.save(cargo), CargoDTO.class);

    }

    @Override
    public CargoDTO delete(Long id) {
        CargoEntity cargo = repositorio.findById(id).get();
        cargo.setEstado("I");
        return mapper.map(repositorio.save(cargo), CargoDTO.class);

    }

    




}

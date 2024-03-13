/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.sistemabarber.SistemaBarber.repository.gestion;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import pe.com.sistemabarber.SistemaBarber.models.gestion.TipoCitasEntity;
import pe.com.sistemabarber.SistemaBarber.repository.base.BaseRepository;

/**
 *
 * @author ACER
 */
@Repository
public interface TipoCitasRepository extends BaseRepository<TipoCitasEntity, Long>{

    public Optional<TipoCitasEntity> findByNombre(String toLowerCase);
    
}

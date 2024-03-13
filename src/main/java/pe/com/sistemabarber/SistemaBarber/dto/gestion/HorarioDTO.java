
package pe.com.sistemabarber.SistemaBarber.dto.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import java.sql.Time;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.dto.base.BaseDTO;

/**
 *
 * @author ACER
 */
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id_horario", "nombre","hora_inicio", "hora_fin","estado","fecha_creacion","fecha_actualizacion"})

public class HorarioDTO extends BaseDTO{
        private String  nombre;
    private  String hora_inicio;
    private String hora_fin;
    private String estado;

    private LocalDateTime fecha_creacion;

  private LocalDateTime fecha_actualizacion;


    

    
    
}

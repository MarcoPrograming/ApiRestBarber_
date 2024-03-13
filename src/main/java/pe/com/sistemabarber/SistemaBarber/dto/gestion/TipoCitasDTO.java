package pe.com.sistemabarber.SistemaBarber.dto.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@JsonPropertyOrder({"cod_tipo_citas", "nombre","descripcion", "estado","fecha_creacion","fecha_actualizacion"})

public class TipoCitasDTO extends BaseDTO{
        private String nombre;
    private String descripcion;
    private String estado;
    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_actualizacion;

    
    
}

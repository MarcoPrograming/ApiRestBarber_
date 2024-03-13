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
@JsonPropertyOrder({"cod_cliente", "nombres","apellidos", "edad","email",
    "telefono","direccion","estado","fecha_creacion","fecha_actualizacion"})

public class ClienteDTO {
    private long id;
        private String nombres;
    private String apellidos;
    private Integer edad;
    private String email;
    private String telefono;
    private String direccion;
    private String estado;
    private LocalDateTime fecha_creacion;

    private LocalDateTime fecha_actualizacion;


    
}

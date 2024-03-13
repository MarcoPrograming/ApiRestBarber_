package pe.com.sistemabarber.SistemaBarber.dto.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.dto.base.BaseDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.EmpleadoEntity;

import java.time.LocalDateTime;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"idServicio", "empleado", "nombre", "precio", "estado", "fechaCreacion", "fechaActualizacion"})
public class ServicioDTO extends BaseDTO {

    private Long idServicio;
    private EmpleadoEntity empleado;
    private String nombre;
    private double precio;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}

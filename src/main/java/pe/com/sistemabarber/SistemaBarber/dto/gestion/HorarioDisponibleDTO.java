package pe.com.sistemabarber.SistemaBarber.dto.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.dto.base.BaseDTO;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id_horariodi", "fecha","nombre","hora_inicio", "hora_fin","estado","fecha_creacion"})

public class HorarioDisponibleDTO extends BaseDTO {
    private Date fecha;
            private String  nombre;
    private  String hora_inicio;
    private String hora_fin;
    private String estado;
    private LocalDateTime fecha_creacion;



}

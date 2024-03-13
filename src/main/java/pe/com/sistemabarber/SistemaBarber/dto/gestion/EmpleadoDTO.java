package pe.com.sistemabarber.SistemaBarber.dto.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.dto.base.BaseDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CargoEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.HorarioEntity;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id_empleado", "cargo", "horario", "nombre", "apellidos", "tipoDoc","numDoc", "edad",
        "correo", "telefono", "direccion", "estado", "fecha_creacion", "fecha_actualizacion"})
public class EmpleadoDTO extends BaseDTO {

    private CargoEntity cargo;
    private HorarioEntity horario;
    private String nombre;
    private String apellidos;
    private String tipoDoc;
    private  String numDoc;
    private int edad;
    private String correo;
    private String telefono;
    private String direccion;
    private String estado;
    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_actualizacion;

    
    

}

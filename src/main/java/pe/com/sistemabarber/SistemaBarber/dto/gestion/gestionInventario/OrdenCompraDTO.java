package pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario;

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
import pe.com.sistemabarber.SistemaBarber.models.gestion.EmpleadoEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.ProveedorEntity;

/**
 *
 * @author ACER
 */
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id_ordenco","id_empleado","id_proveedor", "titulo","fecha","total","estado",
"fecha_creacion","fecha_actualizacion"})
public class OrdenCompraDTO extends BaseDTO {
    private EmpleadoEntity empleado;
        private ProveedorEntity proveedor;

        private String titulo;
     private Date fecha;
      private Double total;
          private String estado;
        private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_actualizacion;




}

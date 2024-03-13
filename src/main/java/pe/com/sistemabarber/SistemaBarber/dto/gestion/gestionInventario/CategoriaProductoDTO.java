package pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@JsonPropertyOrder({"id_cat", "nombre","descripcion", "estado","fecha_creacion", "fecha_actualizacion"})

public class CategoriaProductoDTO extends BaseDTO{

    private String nombre;
     
    private String descripcion;
        private String estado;

      private LocalDateTime fecha_creacion;

    private LocalDateTime fecha_actualizacion;


}
